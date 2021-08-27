package gov.hhs.acf.cb.nytds.persistence.fullrecord;

import gov.hhs.acf.cb.nytds.persistence.entity.Datum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatumFullRecordRepository extends JpaRepository<Datum,Long> {

    final String QUERY = "select datum "
            + "from Datum as datum "
            + "join datum.transmissionRecord as record "
            + "join record.transmission as transmission "
            + "join datum.element as element "
            + "where transmission.id = :transmissionID "
            + "order by record.id asc, element.sort asc ";

    @Query(QUERY)
    List<Datum> findAllDatum(Long transmissionID);


}
