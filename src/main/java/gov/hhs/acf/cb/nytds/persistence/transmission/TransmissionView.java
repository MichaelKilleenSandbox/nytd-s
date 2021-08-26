package gov.hhs.acf.cb.nytds.persistence.transmission;

import org.springframework.beans.factory.annotation.Value;

/**
 * This is an example of a "projection". It allows us to return data in a format different than the default
 * of the Entity class. So if we only want a few fields or if we want to return just part of a nested
 * class we can do using a projection.
 */
public interface TransmissionView {
    // This creates a "Open Projection".
    @Value("#{target.transmissionType.name}")
    String getTransmissionType();
//    ReportingPeriod getReportingPeriod();
    String getName();
    String getComplianceStatus();
    String getProcessingStatus();
    String getSubmissionStatus();
}
