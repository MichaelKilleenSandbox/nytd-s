package gov.hhs.acf.cb.nytds.persistence.message;

import gov.hhs.acf.cb.nytds.persistence.entity.Message;
import gov.hhs.acf.cb.nytds.persistence.entity.NYTDSystem;
import gov.hhs.acf.cb.nytds.util.DateUtil;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MessageRepositoryImpl implements MessageSearchRepository {

    private final EntityManager entityManager;
    private static final String CREATED_DATE = "createdDate";

    private final Logger log = Logger.getLogger(getClass());

    public MessageRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public MessageSearch search(MessageSearch search) {
        log.info("TODO: No replacement of setResultTransformer() available until Hibernate 6.0");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<Message> cq = cb.createQuery(Message.class);
        Root<Message> root = cq.from(Message.class);
        List<Message> books = entityManager.createQuery(cq).getResultList();
        List<Predicate> predicateList = new ArrayList<>();


        // create the criteria object
        DetachedCriteria criteria = DetachedCriteria.forClass(Message.class);
        // restrict messages to currently logged-in user
        DetachedCriteria userCriteria = criteria.createCriteria("recipients");
        userCriteria.add(Restrictions.eq("id", search.getUser().getId()));


        // check for matching text in the message subject and body
        if (search.getText() != null && !search.getText().isEmpty()) {
            Disjunction disjunction = Restrictions.disjunction();
            criteria.add(disjunction);
            for (String token : search.getText().split(" ")) {
                predicateList.add(cb.or(
                    cb.like(cb.lower(root.get("subject")),"%" + token + "%"),
                    cb.like(cb.lower(root.get("messageBody")),"%" + token + "%")));
//                disjunction.add(Restrictions.like("subject", "%" + token + "%").ignoreCase());
//                disjunction.add(Restrictions.like("messageBody", "%" + token + "%").ignoreCase());
            }
        }

        // constrain messages to a specific date range
        String formStartDate = search.getMessageCreatedStartDate();
        String formEndDate = search.getMessageCreatedEndDate();
        if (formStartDate != null && !formStartDate.isEmpty()) {
            String startDateRestriction;
            Calendar startDate = DateUtil.toCalendar(formStartDate);
            //startDateRestriction = String.format("trunc({alias}.%s) >= trunc(?)", CREATED_DATE);
            predicateList.add(cb.greaterThanOrEqualTo(root.get("startDate"), Calendar.getInstance()));
            //criteria.add(Restrictions.sqlRestriction(startDateRestriction, startDate, CalendarType.INSTANCE));
        }
        if (formEndDate != null && !formEndDate.isEmpty()) {
            String endDateRestriction;
            Calendar endDate = DateUtil.toCalendar(formEndDate);
            //endDateRestriction = String.format("trunc({alias}.%s) <= trunc(?)", CREATED_DATE);
            predicateList.add(cb.lessThanOrEqualTo(root.get("endDate"), Calendar.getInstance()));
            //criteria.add(Restrictions.sqlRestriction(endDateRestriction, endDate, CalendarType.INSTANCE));
        }

        cq.select(root).where(predicateList.toArray(Predicate[]::new));
        Query query = entityManager.createQuery(cq);

        final var resultList = query.getResultList();
        Pageable pageable = Pageable.ofSize(search.getPageSize()).withPage(search.getPage());

        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        int totalRows = query.getResultList().size();
        Page<Message> result = new PageImpl<Message>(query.getResultList(), pageable, totalRows);

        // add sort
        if (search.getSortColumn() != null) {
            switch (search.getSortDirection()) {
                case ASC:
                    cq.orderBy(cb.asc(root.get(search.getSortColumn())));
                    //criteria.addOrder(Order.asc(search.getSortColumn()));
                    break;
                case DESC:
                    cq.orderBy(cb.desc(root.get(search.getSortColumn())));
                    break;
            }
        } else {
            // default sort order
            //criteria.addOrder(Order.desc("reportingPeriod"));
            cq.orderBy(cb.desc(root.get(CREATED_DATE)));
            search.setSortColumn(CREATED_DATE);
            //search.setSortDirection(PaginatedSearch.SortDirection.DESC);
        }

        // execute count query to return row count

        search.setRowCount(totalRows);

        // TODO mjk 9/6/2021 Check this code out as it's suspicious. Calls to ExtendedDueDateDaoImpl???!!!
        // execute result query. limit results if page size > 0
//        Criteria resultsCriteria = criteria.getExecutableCriteria(getSessionFactory().getCurrentSession());
//        ExtendedDueDateDaoImpl.getPages(resultsCriteria, search.getPageSize(), search.getPage());
//
//        // add transient message properties
//        List<Message> messages = resultsCriteria.list();
//        for (Message message : messages) {
//            if (message.getCreatedDate() != null) {
//                Calendar cal = message.getCreatedDate();
//                message.setMessageCreatedDate(DateUtil.formatDateAndTimezone(DateFormat.LONG, cal));
//            }
//            prepareSystemMessage(message);
//        }

        // return results
        search.setPageResults(resultList);
        return search;
    }

    private Message prepareSystemMessage(Message systemMsg) {
        NYTDSystem nytdSystem = new NYTDSystem();
        systemMsg.setMessageFrom(nytdSystem.getName());
        systemMsg.setSignature(nytdSystem.getSignature());
        systemMsg.setBeforeSignatureWord(nytdSystem.getBeforSignatureWord());

        return systemMsg;
    }
}
