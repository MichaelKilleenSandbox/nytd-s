package gov.hhs.acf.cb.nytds.persistence.element;

import gov.hhs.acf.cb.nytds.persistence.entity.Element;

import java.util.Map;
import java.util.Optional;

public interface ElementDALService {

    Map<String, String> instanceOfElementSelectMap();

    Optional<Element> findElementByName(String elementName);

    Map<String, String> findElementSelectMapForFrequencies();
}
