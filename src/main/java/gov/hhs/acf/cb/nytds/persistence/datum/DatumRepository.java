package gov.hhs.acf.cb.nytds.persistence.datum;

import gov.hhs.acf.cb.nytds.persistence.entity.Datum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface DatumRepository extends JpaRepository<Datum,Long> {

    List<Datum> findDatumByTransmissionRecord_IdOrderByElement_Id(Long transmissionRecordId);

}
