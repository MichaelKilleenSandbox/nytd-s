package gov.hhs.acf.cb.nytds.persistence.transmission;

import gov.hhs.acf.cb.nytds.persistence.entity.helper.VwTransmissionStatus;
import gov.hhs.acf.cb.nytds.util.UserRoleEnum;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository
public class VwTransmissionStatusRepoImpl implements VwTransmissionStatusRepo {

    private static final String FILE_TYPE_EXEPTION_STATUS = "Exited Not Expected File Category";

    private EntityManager entityManager;

    public VwTransmissionStatusRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<VwTransmissionStatus> findVwTransmissionStatusByAdminFedRole(UserRoleEnum role) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VwTransmissionStatus> criteriaQuery = criteriaBuilder.createQuery(VwTransmissionStatus.class);
        Root<VwTransmissionStatus> root = criteriaQuery.from(VwTransmissionStatus.class);
        criteriaQuery.where(criteriaBuilder.lessThan(root.get("submittedDate"), Calendar.getInstance()));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("submittedDate")));

        // dashboard results are limited to 5
        int maxResults = 5;
        criteriaQuery.select(root);
        TypedQuery<VwTransmissionStatus> q = entityManager.createQuery(criteriaQuery);
        q.setFirstResult(0);
        q.setMaxResults(maxResults);
        return q.getResultList();
    }

    @Override
    public List<VwTransmissionStatus> findVwTransmissionStatusByStateRole(String stateName) {
        // JPA 2.0
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VwTransmissionStatus> criteriaQuery = criteriaBuilder.createQuery(VwTransmissionStatus.class);
        Root<VwTransmissionStatus> root = criteriaQuery.from(VwTransmissionStatus.class);

        criteriaQuery.where(criteriaBuilder.equal(root.get("state"), stateName),
        criteriaBuilder.notEqual(root.get("processingStatus"), FILE_TYPE_EXEPTION_STATUS));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("fileReceivedDate")));

        // dashboard results are limited to 5
        int maxResults = 5;
        //New JPA 2.0
        criteriaQuery.select(root);
        TypedQuery<VwTransmissionStatus> q = entityManager.createQuery(criteriaQuery);
        q.setFirstResult(0);
        q.setMaxResults(maxResults);
        return q.getResultList();
    }

    @Override
    public List<VwTransmissionStatus> findVwTransmissionStatusByRegionalRole(String region) {
        // JPA 2.0
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VwTransmissionStatus> criteriaQuery = criteriaBuilder.createQuery(VwTransmissionStatus.class);
        Root<VwTransmissionStatus> root = criteriaQuery.from(VwTransmissionStatus.class);

        //JPA 2.0
        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(root.get("region")));
        predicates.add(criteriaBuilder.equal(root.get("region"), region));
        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("submittedDate"), Calendar.getInstance()));
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("submittedDate")));

        // dashboard results are limited to 5
        int maxResults = 5;
        //New JPA 2.0
        criteriaQuery.select(root);
        TypedQuery<VwTransmissionStatus> q = entityManager.createQuery(criteriaQuery);
        q.setFirstResult(0);
        q.setMaxResults(maxResults);
        return q.getResultList();
    }


}
