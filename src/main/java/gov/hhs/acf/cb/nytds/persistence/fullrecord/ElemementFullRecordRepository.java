package gov.hhs.acf.cb.nytds.persistence.fullrecord;

import gov.hhs.acf.cb.nytds.persistence.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ElemementFullRecordRepository extends JpaRepository<Element,Long> {
    @Query("select element from Element as element order by element.sort asc")
    List<Element> findAllElements();

}
