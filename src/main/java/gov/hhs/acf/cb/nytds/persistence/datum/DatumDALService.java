package gov.hhs.acf.cb.nytds.persistence.datum;

import gov.hhs.acf.cb.nytds.persistence.entity.Datum;

import java.util.List;

@Deprecated
public interface DatumDALService {
    List<Datum> findDatumByTransmissionRecordId(Long transmissionRecordId);
}
