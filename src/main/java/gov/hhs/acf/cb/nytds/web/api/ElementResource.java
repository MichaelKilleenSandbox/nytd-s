package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.element.ElementDALService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ElementResource {
    private ElementDALService elementDALService;

    public ElementResource(ElementDALService elementDALService) {
        this.elementDALService = elementDALService;
    }

    @GetMapping("/element")
    ResponseEntity<Map<String,String>> getElements() {
        var mapOfElements = elementDALService.instanceOfElementSelectMap();
        return ResponseEntity.ok(mapOfElements);
    }
}
