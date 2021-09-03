package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.entity.VwExtendedDueDate;
import gov.hhs.acf.cb.nytds.persistence.extendedduedate.ExtendedDueDateSearch;
import gov.hhs.acf.cb.nytds.persistence.extendedduedate.ExtendedDueDateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExtendedDueDateResource {
    private ExtendedDueDateService extendedDueDateService;

    public ExtendedDueDateResource(ExtendedDueDateService extendedDueDateService) {
        this.extendedDueDateService = extendedDueDateService;
    }


    @GetMapping("/extendedduedate")
    public ResponseEntity<List<VwExtendedDueDate>> getExtendedDueDates() {
        ExtendedDueDateSearch extendedDueDateSearch = ExtendedDueDateSearch.create();
        final var extendedDueDateData = extendedDueDateService.getExtendedDueDateData(extendedDueDateSearch);
        return ResponseEntity.ok(extendedDueDateData);
    }
}
