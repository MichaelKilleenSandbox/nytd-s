package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.component.state.StateBusinessObject;
import gov.hhs.acf.cb.nytds.persistence.component.state.StateService;
import gov.hhs.acf.cb.nytds.persistence.component.entity.State;
import gov.hhs.acf.cb.nytds.persistence.component.state.StateView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloWorldResource {

    private StateService stateService;

    public HelloWorldResource(StateService stateService) {
        this.stateService = stateService;
    }


    @GetMapping("/helloworld")
    ResponseEntity<StateBusinessObject> getHelloWorld() {
        System.out.println("TEST");
        Optional<StateBusinessObject> stateOptional = stateService.findStateByAbbreviation("NY");
        StateBusinessObject state = stateOptional.get();
        return ResponseEntity.ok(state);
    }

}
