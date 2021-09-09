package gov.hhs.acf.cb.nytds.persistence.transmissionrecord;

import org.springframework.stereotype.Service;

@Service
public class TransmissionRecordDALServiceImpl implements TransmissionRecordDALService {

    private TransmissionRecordRepository transmissionRecordRepository;

    public TransmissionRecordDALServiceImpl(TransmissionRecordRepository transmissionRecordRepository) {
        this.transmissionRecordRepository = transmissionRecordRepository;
    }

    @Override
    public Long findCountBaselineYouth(Long transmissionId) {
        return transmissionRecordRepository.countTransmissionRecordsByTransmission_IdAndOutcomePopulation_Name(transmissionId,"Baseline");
    }

    @Override
    public Long findCountFollowupYouth(Long transmissionId) {
        return transmissionRecordRepository.countTransmissionRecordsByTransmission_IdAndOutcomePopulation_NameContains(transmissionId,"Follow-up");
    }

    @Override
    public Long findCountServedYouth(Long transmissionId) {
        return transmissionRecordRepository.countTransmissionRecordsByTransmission_IdAndServedPopulationIsNotNull(transmissionId);
    }

    @Override
    public Long findCountTotalRecords(Long transmissionId) {
        return transmissionRecordRepository.countTransmissionRecordsByTransmission_Id(transmissionId);
    }


}
