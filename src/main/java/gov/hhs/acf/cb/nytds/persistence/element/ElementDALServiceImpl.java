package gov.hhs.acf.cb.nytds.persistence.element;

import gov.hhs.acf.cb.nytds.persistence.entity.Element;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class ElementDALServiceImpl implements ElementDALService {

    private ElementRepository elementRepository;
    private Map<String,String>  elementSelectMap;

    public ElementDALServiceImpl(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    @Override
    public Map<String, String> instanceOfElementSelectMap() {
        List<ElementView> elementViewList = elementRepository.findByOrderBySort();

        if(elementSelectMap == null) {
            this.elementSelectMap = new LinkedHashMap<>();
            elementViewList.forEach(elementView -> {
                elementSelectMap.put(
                        String.valueOf(elementView.getId()),
                        String.format("%s %s", elementView.getName(), elementView.getDescription()));
            });
        }
        return elementSelectMap;
    }

    @Override
    public Optional<Element> findElementByName(String elementName) {
        return Optional.ofNullable(elementRepository.findElementByName(elementName));
    }

    @Override
    public Map<String, String> findElementSelectMapForFrequencies()
    {
        Map<String, String> selectMap = new LinkedHashMap<>(instanceOfElementSelectMap());

        // Remove elements based on their id. Yes, this is a hack.
        selectMap.remove("3");
        selectMap.remove("4");
        selectMap.remove("35");
        selectMap.remove("15");
        selectMap.remove("1");

        return Collections.unmodifiableMap(selectMap);
    }
}
