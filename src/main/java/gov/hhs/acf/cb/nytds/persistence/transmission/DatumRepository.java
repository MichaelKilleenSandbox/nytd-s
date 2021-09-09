package gov.hhs.acf.cb.nytds.persistence.transmission;

import gov.hhs.acf.cb.nytds.persistence.entity.Datum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatumRepository extends JpaRepository<Datum, Long> {

    final static String DatumNoteQuery = "datum_.rowid as {note.noteId},\n" +
            "this_.RECORDNUMBER as {note.recordNumber},\n" +
            "element_.NAME as {note.elementName},\n" +
            "element_.DESCRIPTION as {note.elementDescription},\n" +
            "datum_.VALUE as {note.datumValue},\n" +
            "datum_.NOTES as {note.noteText}  " +
            "    from TRANSMISSIONRECORD this_\n" +
            "    inner join TRANSMISSION trans_\n" +
            "    on this_.TRANSMISSIONID = trans_.TRANSMISSIONID\n" +
            "    inner join DATUM datum_\n" +
            "    on this_.TRANSMISSIONRECORDID = datum_.TRANSMISSIONRECORDID\n" +
            "    inner join ELEMENT element_\n" +
            "    on datum_.ELEMENTID = element_.ELEMENTID\n" +
            "    where trans_.TRANSMISSIONID = :transmissionId\n" +
            "    and datum_.notes is not null\n" +
            "    order by this_.RECORDNUMBER, element_.NAME";

    List<Datum> findDatumByTransmissionRecord_IdOrderByElement_Id(Long transmissionRecordId);

//    @Query(DatumNoteQuery)
//    List<VwNote> findDatumNotesUsingTransmissionId(@Param("transmissionId") Long transmissionId);




}
