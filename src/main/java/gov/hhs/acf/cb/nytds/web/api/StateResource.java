package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.entity.Region;
import gov.hhs.acf.cb.nytds.persistence.entity.State;
import gov.hhs.acf.cb.nytds.persistence.state.StateDALService;
import gov.hhs.acf.cb.nytds.persistence.state.StateView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StateResource {

    private StateDALService stateService;

    public StateResource(StateDALService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/state")
    public ResponseEntity<List<State>> getAllStates() {
        List<State> states = stateService.findAllStates();
        return ResponseEntity.ok(states);
    }

    @GetMapping("/state/{id}")
    public ResponseEntity<StateView> getStateById(@PathVariable Long id) {
        Optional<StateView> stateOptional = stateService.findStateById(id);
        if(stateOptional.isPresent()) {
            return ResponseEntity.ok(stateOptional.get());
        }
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/state/abbreviation/{stateAbbreviation}")
    public ResponseEntity<StateView> getByStateAbbreviation(@PathVariable String stateAbbreviation) {

        Optional<StateView> stateOptional = stateService.findStateByAbbreviation(stateAbbreviation);
        if(stateOptional.isPresent()) {
            StateView state = stateOptional.get();
            return ResponseEntity.ok(state);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/state/{stateAbbreviation}/region")
    public ResponseEntity<Region> getRegionForState(@PathVariable String stateAbbreviation) {

        Optional<Region> regionOptional = stateService.findAssociatedRegion(stateAbbreviation);
        if(regionOptional.isPresent()) {
            Region region = regionOptional.get();
            return ResponseEntity.ok(region);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/state/{stateAbbreviation}/states")
    public ResponseEntity<List<State>> getAssociatedStates(@PathVariable String stateAbbreviation) {
        List<State> states = stateService.findAssociatedStates(stateAbbreviation);
        return ResponseEntity.ok(states);
    }

}
