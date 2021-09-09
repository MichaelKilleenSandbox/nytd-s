package gov.hhs.acf.cb.nytds.persistence.transmissionrecord;

public interface TransmissionRecordDALService {
    Long findCountBaselineYouth(Long transmissionId);

    Long findCountFollowupYouth(Long transmissionId);

    Long findCountServedYouth(Long transmissionId);

    Long findCountTotalRecords(Long transmissionId);
}
