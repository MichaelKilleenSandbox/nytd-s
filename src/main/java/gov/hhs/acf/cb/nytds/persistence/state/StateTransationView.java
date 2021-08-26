package gov.hhs.acf.cb.nytds.persistence.state;

import gov.hhs.acf.cb.nytds.persistence.entity.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

public interface StateTransationView {
    long getId();

    Set<TransmissionInfo> getTransmissions();

    interface TransmissionInfo {
        long getId();

        String getComplianceStatus();

        String getCreatedBy();

        Calendar getCreatedDate();

        Set<DataAggregate> getDataAggregates();

        String getDataFileReportPeriodValue();

        String getDataFileStateValue();

        String getDataFileTransmissionTypeValue();

        Long getDatvaluecompliantcnt();

        Long getDatvaluedatqualadviscnt();

        String getDescription();

        Long getDuplicateRecordsCnt();

        Set<ElementNote> getElementNotes();

        Long getElementleveldqacnt();

        String getFileGenerationDate();

        String getFileId();

        String getFileName();

        Calendar getFileReceivedDate();

        Integer getFileSize();

        Long getFormatErrCnt();

        Long getImproperFormattedValCnt();

        String getLateWarningMessage();

        String getName();

        Set<NonCompliance> getNonCompliances();

        BigDecimal getPotentialPenalty();

        String getProcessedStatus();

        String getProcessingStatus();

        String getProcessingexception();

        Long getRecordleveldqacnt();

        Long getRecordlevelerrcnt();

        Long getRecordsCnt();

        Long getRecordsinerrorcnt();

        ReportingPeriod getReportingPeriod();

        SiteUser getSiteUser();

        State getState();

        String getSubmissionStatus();

        Calendar getSubmittedDate();

        Long getTimelyerrcnt();

        Set<TransmissionNote> getTransmissionNotes();

        Set<TransmissionRecord> getTransmissionRecords();

        TransmissionType getTransmissionType();

        Long getTransmissionlevelerrcnt();

        String getUpdateBy();

        Calendar getUpdateDate();

        Integer getVersion();

        Long getXmlDataId();
    }
}
