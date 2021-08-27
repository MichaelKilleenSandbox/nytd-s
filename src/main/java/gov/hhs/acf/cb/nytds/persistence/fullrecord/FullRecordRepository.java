package gov.hhs.acf.cb.nytds.persistence.fullrecord;


import gov.hhs.acf.cb.nytds.persistence.entity.RecordToExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FullRecordRepository extends JpaRepository<RecordToExport,Long> {

//    @Query("select fullRecord from RecordToExport as fullRecord inner join fullRecord.transmissionRecord as transmissionRecord where transmissionRecord.id = :transmissionRecordID")
//    List<RecordToExport> findAllTheFullRecordByTransmissionRecord(Long transmissionRecordID);
//
//    @Query("select fullRecord from RecordToExport as fullRecord inner join fullRecord.transmission as transmission where transmission.id = :transmissionID")
//    List<RecordToExport> findFullRecordByTransmission(Long transmissionId);

}
