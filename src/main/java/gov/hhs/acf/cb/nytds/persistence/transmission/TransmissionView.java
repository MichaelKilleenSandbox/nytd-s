package gov.hhs.acf.cb.nytds.persistence.transmission;

import gov.hhs.acf.cb.nytds.persistence.entity.ReportingPeriod;
import gov.hhs.acf.cb.nytds.persistence.entity.TransmissionType;

public interface TransmissionView {
    TransmissionType getTransmissionType();
    ReportingPeriod getReportingPeriod();
    String getName();
    String getComplianceStatus();
    String getProcessingStatus();
    String getSubmissionStatus();
}
