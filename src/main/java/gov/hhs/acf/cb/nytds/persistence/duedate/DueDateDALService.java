package gov.hhs.acf.cb.nytds.persistence.duedate;

import gov.hhs.acf.cb.nytds.persistence.entity.ReportingPeriod;

import java.util.Calendar;
import java.util.Optional;

public interface DueDateDALService {
    Optional<Calendar> findSubmissionDeadline(ReportingPeriod period, Long transmissionTypeId);
}
