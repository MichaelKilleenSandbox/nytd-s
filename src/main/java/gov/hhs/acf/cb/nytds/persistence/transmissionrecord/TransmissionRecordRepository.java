package gov.hhs.acf.cb.nytds.persistence.transmissionrecord;

import gov.hhs.acf.cb.nytds.persistence.entity.TransmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransmissionRecordRepository extends JpaRepository<TransmissionRecord, Long> {
    long countTransmissionRecordsByTransmission_IdAndOutcomePopulation_Name(Long transmissionId, String name);
    long countTransmissionRecordsByTransmission_IdAndOutcomePopulation_NameContains(Long transmissionId, String name);
    long countTransmissionRecordsByTransmission_IdAndServedPopulationIsNotNull(Long transmissionId);
    long countTransmissionRecordsByTransmission_Id(Long transmissionId);

}
