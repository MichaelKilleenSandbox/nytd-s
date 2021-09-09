package gov.hhs.acf.cb.nytds.persistence.duedate;

import gov.hhs.acf.cb.nytds.persistence.entity.DueDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/*
    String queryString = "select submissionDate "
	            + "from DueDate "
	            + "where reportingPeriodid = :reportingperiodid "
	            + "and transmissionTypeid = :transmissiontypeid ";
 */

public interface DueDateRepository extends JpaRepository<DueDate,Long> {

    Optional<DueDate> findDistinctByReportingPeriod_idAndTransmissionType_id(Long reportingPeriodId, Long transmissionTypeID);

}
