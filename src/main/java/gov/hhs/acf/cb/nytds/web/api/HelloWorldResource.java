package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.service.StateService;
import gov.hhs.acf.cb.nytds.persistence.service.entity.State;
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
    ResponseEntity<String> getHelloWorld() {
        System.out.println("TEST");
        Optional<State> stateOptional = stateService.findStateByAbbreviation("NY");
        State state = stateOptional.get();
        return ResponseEntity.ok(stateOptional.get().toString());
    }

}
