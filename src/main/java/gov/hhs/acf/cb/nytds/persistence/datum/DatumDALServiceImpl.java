package gov.hhs.acf.cb.nytds.persistence.datum;

import gov.hhs.acf.cb.nytds.persistence.entity.Datum;

import java.util.List;

@Deprecated
class DatumDALServiceImpl implements DatumDALService {



    @Override
    public List<Datum> findDatumByTransmissionRecordId(Long transmissionRecordId) {
        return null;
    }
}
