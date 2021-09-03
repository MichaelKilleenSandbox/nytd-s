package gov.hhs.acf.cb.nytds.persistence.extendedduedate;

import gov.hhs.acf.cb.nytds.persistence.entity.ExtendedDueDate;
import gov.hhs.acf.cb.nytds.persistence.entity.VwExtendedDueDate;

import java.util.List;
import java.util.Optional;

/**
 * This service handles operations related to extended due date.
 */
public interface ExtendedDueDateService  {

    /**
     * Get list of due date by due date data by search criteria.
     *
     * @param  search
     * @return list of VwExtendedDueDate
     */
    List<VwExtendedDueDate> getExtendedDueDateData(ExtendedDueDateSearch search);

    /**
     * Get extended due date by due date id and extended due date id.
     *
     * @param  dueDateID
     * @param  extendedDueDateId
     * @return VwExtendedDueDate view extended due date
     */
    Optional<VwExtendedDueDate> getExtendedDueDateByDueDateID(Long dueDateID, Long extendedDueDateId);

    /**
     * Save extended due date.
     *
     * @param list of extendedDueDate
     * @return String result status returned from dao
     */
    String saveExtendedDueDate(List<ExtendedDueDate> extendedDueDate);

    /**
     * Delete extended due date.
     *
     * @param  extendedDueDate
     * @return String result status returned from dao
     */
    String deleteExtendedDueDateData(ExtendedDueDate extendedDueDate);
        
    /**
     * Get a report period name by reporting period id.
     *
     * @param reportingPeriodId id
     * @return String reporting period name
     */
    Optional<String> getReportPeriodNameById(Long reportingPeriodId);
    
    /**
     * Get a state name by state id.
     *
     * @param statId id
     * @return String state name
     */
    Optional<Object> getStateNameById(Long statId);
    
    /**
     * Get list of all state id.
     *
     * @return List<Long> state id list
     */
    List<Long> getAllStateIds();

}
