package gov.hhs.acf.cb.nytds.persistence.element;

import gov.hhs.acf.cb.nytds.persistence.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ElementRepository extends JpaRepository<Element, Long> {

    List<ElementView> findByOrderBySort();

    Element findElementByName(String name);


}
