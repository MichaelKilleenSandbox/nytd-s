package gov.hhs.acf.cb.nytds.persistence.datum;

import gov.hhs.acf.cb.nytds.persistence.entity.Datum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DatumDALServiceImpl implements DatumDALService {
    private DatumRepository datumRepository;

    DatumDALServiceImpl(DatumRepository datumRepository) {
        this.datumRepository = datumRepository;
    }

    @Override
    public List<Datum> findDatumByTransmissionRecordId(Long transmissionRecordId) {
        return datumRepository.findDatumByTransmissionRecord_IdOrderByElement_Id(transmissionRecordId);
    }
}
