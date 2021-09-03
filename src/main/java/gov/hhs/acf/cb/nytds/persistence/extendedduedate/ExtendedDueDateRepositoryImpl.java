package gov.hhs.acf.cb.nytds.persistence.extendedduedate;


import gov.hhs.acf.cb.nytds.persistence.entity.VwExtendedDueDate;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ExtendedDueDateRepositoryImpl implements ExtendedDueDateSearchAndFilterRepository {

    protected final Logger log = Logger.getLogger(getClass());

    private EntityManager entityManager;

    public ExtendedDueDateRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<VwExtendedDueDate> findExtendedDueDateData(ExtendedDueDateSearch search) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<VwExtendedDueDate> cq = cb.createQuery(VwExtendedDueDate.class);
        Root<VwExtendedDueDate> root = cq.from(VwExtendedDueDate.class);

        List<VwExtendedDueDate> list = new ArrayList<>();
        List<Predicate> predicateList = new ArrayList<>();

        try {

            predicateList.add(cb.or(
                    cb.isNull(root.get("deleteFlag")),
                    cb.equal(root.get("deleteFlag"),'0')));

            if (null != StringUtils.trimToNull(search.getState()) && !search.getState().equalsIgnoreCase("0")) {
                predicateList.add(cb.equal(root.get("eddStateId"),Long.parseLong(search.getState())));
                //criteria.add(Restrictions.eq("eddStateId", Long.parseLong(search.getState())));
            }
            if (null != StringUtils.trimToNull(search.getReportingPeriod())
                    && !search.getReportingPeriod().equalsIgnoreCase("0")) {
                predicateList.add(cb.equal(root.get("reportingPeriodId"),Long.parseLong(search.getReportingPeriod())));
                //criteria.add(Restrictions.eq("reportingPeriodId", Long.parseLong(search.getReportingPeriod())));
            }
            if ( search.getExtendedDueDate() != null ) {
                predicateList.add(cb.greaterThan(root.get("extendedDueDate"),search.getExtendedDueDate()));
                //criteria.add(Restrictions.gt("extendedDueDate", search.getExtendedDueDate()));
            }

            String columnNameToSortOn = sortExtendedDueDateData(search);

            // add sort
            if (search.getSortColumn() != null) {
                switch (search.getSortDirection()) {
                    case ASC:
                        cq.orderBy(cb.asc(root.get(columnNameToSortOn)));
                        break;
                    case DESC:
                        cq.orderBy(cb.desc(root.get(columnNameToSortOn)));
                        break;
                }
            } else {
                // default sort order
                //criteria.addOrder(Order.desc("reportingPeriod"));
                cq.orderBy(cb.desc(root.get("startReportingDate")));
                search.setSortColumn("startReportingDate");
                //search.setSortDirection(PaginatedSearch.SortDirection.DESC);
            }

            cq.select(root).where(predicateList.toArray(Predicate[]::new));
            Query query = entityManager.createQuery(cq);
/*
 TODO mjk 9/2/2021 check into if we need this to be pageable.
            Pageable pageable = Pageable.ofSize(search.getPageSize()).withPage(search.getPage());

            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());
            int totalRows = query.getResultList().size();
            Page<VwTransmissionStatus> result = new PageImpl<VwTransmissionStatus>(query.getResultList(), pageable, totalRows);

 */

        } catch (Exception ex) {
            log.info("Exception inside method getSubmissionDueDateData in  >>>>>>>>>>>>>>>>>>>>>>>>" + ex.getMessage());
        }

        return list;

    }

    @Override
    public Optional<VwExtendedDueDate> findExtendedDueDateByDueDateID(Long dueDateID, Long extendedDueDateId) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VwExtendedDueDate> criteriaQuery = criteriaBuilder.createQuery(VwExtendedDueDate.class);
        Root<VwExtendedDueDate> root = criteriaQuery.from(VwExtendedDueDate.class);
        if(extendedDueDateId != null) {
            criteriaQuery.where(
                    criteriaBuilder.and(
                            criteriaBuilder.equal(root.get("id"), dueDateID),
                            criteriaBuilder.equal(root.get("extendedDueDateId"), extendedDueDateId)
                    )
            );
        } else {
            criteriaQuery.where(
                    criteriaBuilder.and(
                            criteriaBuilder.equal(root.get("id"), dueDateID)
                    )
            );
        }
        criteriaQuery.select(root);
        TypedQuery<VwExtendedDueDate> q = entityManager.createQuery(criteriaQuery);
        try {
            return Optional.of(q.getSingleResult());
        } catch (HibernateException he) {
            log.error("error in query getExtendedDueDateByDueDateID: "+he.getMessage());
        }

        return Optional.empty();
    }

    /*
     * Data sorting based on selected column initially data will be displayed for all states and reporting periods,
     * a default column for data sorting is reporting period
     * @param ExtendedDueDateSearch search
     * @param DetachedCriteria criteria
     * @return DetachedCriteria criteria with sorting
     */
    private String sortExtendedDueDateData(ExtendedDueDateSearch search) {
        if (search.getSortColumn() != null) {
            String columnName = "";
            if(search.getSortColumn().equalsIgnoreCase("startReportingDate")) {
                columnName = "startReportingDate";
            } else if(search.getSortColumn().equalsIgnoreCase("endReportingDate")) {
                columnName = "endReportingDate";
            } else if(search.getSortColumn().equalsIgnoreCase("reportingPeriodName")) {
                columnName = "reportingPeriodName";
            } else if(search.getSortColumn().equalsIgnoreCase("outcomeAge")) {
                columnName = "outComeAge";
            } else if(search.getSortColumn().equalsIgnoreCase("transmissionTypeName")) {
                columnName = "transmissionTypeName";
            } else if(search.getSortColumn().equalsIgnoreCase("submissionDate")) {
                columnName = "submissionDate";
            } else if(search.getSortColumn().equalsIgnoreCase("stateName")) {
                columnName = "eddStateName";
            } else if(search.getSortColumn().equalsIgnoreCase("updateBy")) {
                columnName = "extendedUpdateBy";
            } else if(search.getSortColumn().equalsIgnoreCase("updateDate")) {
                columnName = "extendedUpdateDate";
            } else {
                columnName = "extendedDueDate";
            }
            return columnName;
        }

        return "startReportingDate";
    }
}
