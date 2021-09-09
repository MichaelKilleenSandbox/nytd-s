package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.entity.ExtendedDueDate;
import gov.hhs.acf.cb.nytds.persistence.extendedduedate.ExtendedDueDateSearch;
import gov.hhs.acf.cb.nytds.persistence.extendedduedate.ExtendedDueDateDALService;
import gov.hhs.acf.cb.nytds.persistence.state.StateDALService;
import gov.hhs.acf.cb.nytds.persistence.state.StateView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ExtendedDueDateResource {
    private ExtendedDueDateDALService extendedDueDateService;
    private StateDALService stateDALService;

    public ExtendedDueDateResource(ExtendedDueDateDALService extendedDueDateService, StateDALService stateDALService) {
        this.extendedDueDateService = extendedDueDateService;
        this.stateDALService = stateDALService;
    }


    @GetMapping("/extendedduedate/state/{stateAbbr}")
    public ResponseEntity<List<ExtendedDueDate>> getExtendedDueDates(@PathVariable String stateAbbr) {

        Optional<StateView> state = stateDALService.findStateByAbbreviation(stateAbbr);
        ExtendedDueDateSearch extendedDueDateSearch = ExtendedDueDateSearch.create();
        List<ExtendedDueDate> dueDates = extendedDueDateService.findByStateId(state.get().getId());

        //final var extendedDueDateData = extendedDueDateService.getExtendedDueDateData(extendedDueDateSearch);
        return ResponseEntity.ok(dueDates);
    }
}
