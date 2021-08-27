package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.extendedduedate.ExtendedDueDateDALService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtendedDueDateResource {
    private ExtendedDueDateDALService extendedDueDateDALService;

    public ExtendedDueDateResource(ExtendedDueDateDALService extendedDueDateDALService) {
        this.extendedDueDateDALService = extendedDueDateDALService;
    }

    @GetMapping("/extendedduedate")
    public ResponseEntity<String> getExtendedDueDates() {
        return ResponseEntity.badRequest().build();
    }
}
