package gov.hhs.acf.cb.nytds.persistence.extendedduedate;


import gov.hhs.acf.cb.nytds.persistence.entity.VwExtendedDueDate;

import java.util.List;
import java.util.Optional;

public interface ExtendedDueDateSearchAndFilterRepository {
    /**
     * Returns list of VwExtendedDueDate by extended due date search.
     * @param search
     * @return List<VwExtendedDueDate>
     */
    List<VwExtendedDueDate> findExtendedDueDateData(ExtendedDueDateSearch search);

    /**
     * Returns VwExtendedDueDate by due date id and extended due date id.
     * @param dueDateID
     * @param extendedDueDateId
     * @return VwExtendedDueDate
     */
    Optional<VwExtendedDueDate> findExtendedDueDateByDueDateID(Long dueDateID, Long extendedDueDateId);

}
