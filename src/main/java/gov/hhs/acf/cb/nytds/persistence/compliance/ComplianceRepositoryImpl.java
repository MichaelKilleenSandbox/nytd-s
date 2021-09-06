package gov.hhs.acf.cb.nytds.persistence.compliance;

import gov.hhs.acf.cb.nytds.persistence.entity.helper.VwTransmissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
class ComplianceRepositoryImpl implements ComplianceSearchRepository {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    ComplianceRepositoryImpl(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManager;
    }

    @Override
    public ComplianceSearch searchDataAggregates(ComplianceSearch search) {
        return search;
    }

    @Override
    public PenaltySearch searchAggregatePenalties(PenaltySearch search) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<VwTransmissionStatus> cq = cb.createQuery(VwTransmissionStatus.class);
        Root<VwTransmissionStatus> root = cq.from(VwTransmissionStatus.class);

        List<Predicate> predicateList = new ArrayList<>();

        // add state name restriction to criteria
        String stateName = search.getStateName();
        if (stateName != null && !stateName.isEmpty()) {
            String[] stateNames = stateName.split(";");
            if (stateNames.length > 0 && !(stateName.trim()).equalsIgnoreCase("All")) {
                predicateList.add(root.get("state").in(stateNames));
               //criteria.add(Restrictions.in("state", stateNames));
            }
        }

        // generatePenaltiesLetters to get the results with selected states
        Collection<String> selectedStates = search.getSelectedStates().values();
        if (!selectedStates.isEmpty()) {
            predicateList.add(root.get("state").in(selectedStates));
            //criteria.add(Restrictions.in("state", selectedStates));
        }


        // add compliance status to criteria
        String complianceStatus = search.getComplianceStatus();
        if (complianceStatus != null
                && (!complianceStatus.isEmpty() && (!(complianceStatus.trim()).equalsIgnoreCase("All")))) {
            predicateList.add(cb.equal(root.get("complianceStatus"),complianceStatus.trim()));
            //criteria.add(Restrictions.eq("complianceStatus", complianceStatus.trim()));
        }

        // restrict to specified reporting periods
        Collection<String> names = search.getSelectedReportingPeriods();
        if (names != null && names.size() > 0) {
            predicateList.add(root.get("reportingPeriod").in(names));
            //criteria.add(Restrictions.in("reportingPeriod", names));
        }


        // restrict results to submitted transmissions
        if (search.isViewSubmissionsOnly()) {
            predicateList.add(root.get("submittedDate").isNotNull());
            //criteria.add(Restrictions.isNotNull("submittedDate"));
        }
        if (search.isViewActiveSubmissionsOnly()) {
            predicateList.add(cb.equal(cb.lower(root.get("submissionStatus")),("active")));
//            criteria.add(Restrictions.disjunction().add(Restrictions.eq("submissionStatus", "Active")).add(
//                    Restrictions.eq("submissionStatus", "active")));
        }
        String timelyData = search.getTimelyData();
        if (timelyData != null && !timelyData.isEmpty() && !timelyData.equalsIgnoreCase("All")) {
            predicateList.add(cb.equal(root.get("timelyErrCnt"),new BigDecimal(timelyData)));
            //criteria.add(Restrictions.eq("timelyErrCnt", new BigDecimal(timelyData)));
        }

        String correctFormatData = search.getCorrectFormatData();
        if (correctFormatData != null && !correctFormatData.isEmpty()
                && !correctFormatData.equalsIgnoreCase("All")) {
            predicateList.add(cb.equal(root.get("formatErrCnt"),new BigDecimal(correctFormatData)));
            //criteria.add(Restrictions.eq("formatErrCnt", new BigDecimal(correctFormatData)));
        }

        String errorFreeData = search.getErrorFreeData();
        if (errorFreeData != null && !errorFreeData.isEmpty() && !errorFreeData.equalsIgnoreCase("All")) {

            if (Integer.parseInt(errorFreeData) == 0) {
                predicateList.add(cb.equal(root.get("datValueCompliantCnt"),new BigDecimal(0)));
                //criteria.add(Restrictions.eq("datValueCompliantCnt", new BigDecimal(0)));
            } else {
                predicateList.add(cb.greaterThan(root.get("datValueCompliantCnt"),new BigDecimal(0)));
                //criteria.add(Restrictions.gt("datValueCompliantCnt", new BigDecimal(0)));
            }
        }

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
            cq.orderBy(cb.desc(root.get("reportingPeriod")));
            search.setSortColumn("reportingPeriod");
            //search.setSortDirection(PaginatedSearch.SortDirection.DESC);
        }

        cq.select(root).where(predicateList.toArray(Predicate[]::new));
        Query query = entityManager.createQuery(cq);

        // Run the query constructed above and extract the result
        // execute result query. limit results if page size > 0
        List transmissionList = query.getResultList();

        Pageable pageable = Pageable.ofSize(search.getPageSize()).withPage(search.getPage());

        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        int totalRows = query.getResultList().size();
        Page<VwTransmissionStatus> result = new PageImpl<VwTransmissionStatus>(query.getResultList(), pageable, totalRows);

        // mjk 9/1/2021 Removed temporarily. ExtendedDueDateDaoImpl.getPages(resultsCriteria, search.getPageSize(), search.getPage());

        search.setPageResults(transmissionList);

        return search;
    }


}
