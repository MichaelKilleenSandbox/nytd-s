package gov.hhs.acf.cb.nytds.persistence.fullrecord;

import gov.hhs.acf.cb.nytds.persistence.entity.RecordToExport;
import gov.hhs.acf.cb.nytds.persistence.entity.Transmission;
import gov.hhs.acf.cb.nytds.persistence.entity.TransmissionRecord;

import java.util.List;

public interface FullRecordDALService {
    /**
     * Retrieves a RecordToExport that corresponds to the given TransmissionRecord object.
     *
     * @param transmissionRecord the TransmissionRecord object to convert
     * @return the RecordToExport that corresponds to the given TransmissionRecord object
     */
    RecordToExport findFullRecord(TransmissionRecord transmissionRecord);

    /**
     * Retrieves a list of RecordToExport objects corresponding to the records in a given transmission.
     *
     * The RecordToExport objects returned *should not* be placed in the database if they
     * were not already there in the first place.
     *
     * @param transmission transmission for which to return RecordToExport objects
     * @return list of RecordToExport objects corresponding to records in given transmission
     */
    List<RecordToExport> findFullRecordsForTransmission(Transmission transmission);
}
