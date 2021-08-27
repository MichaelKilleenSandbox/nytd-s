package gov.hhs.acf.cb.nytds.persistence.extendedduedate;

import gov.hhs.acf.cb.nytds.persistence.entity.ExtendedDueDate;
import gov.hhs.acf.cb.nytds.persistence.entity.VwExtendedDueDate;

import java.util.List;

public interface ExtendedDueDateDALService {
    /**
     * Returns list of VwExtendedDueDate by extended due date search.
     * @param ExtendedDueDateSearch search
     * @return List<VwExtendedDueDate>
     */
    List<VwExtendedDueDate> findExtendedDueDateData(ExtendedDueDateSearch search);

    /**
     * Returns VwExtendedDueDate by due date id and extended due date id.
     * @param Long dueDateID
     * @param Long extendedDueDateId
     * @return VwExtendedDueDate
     */
    VwExtendedDueDate findExtendedDueDateByDueDateID(Long dueDateID, Long extendedDueDateId);

    /**
     * Save list of extended due date.
     * @param List<ExtendedDueDate> extendedDueDate
     * @return String as result status
     */
    String saveExtendedDueDate(List<ExtendedDueDate> extendedDueDate);

    /**
     * Delete extended due date.
     * @param ExtendedDueDate extendedDueDate
     * @return String as result status
     */
    String deleteExtendedDueDateData(ExtendedDueDate extendedDueDate);
}
