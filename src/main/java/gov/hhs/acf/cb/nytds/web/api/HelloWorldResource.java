package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.component.entity.State;
import gov.hhs.acf.cb.nytds.persistence.component.state.StateBusinessObject;
import gov.hhs.acf.cb.nytds.persistence.component.state.StateService;
import gov.hhs.acf.cb.nytds.persistence.component.state.StateView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HelloWorldResource {

    private StateService stateService;

    public HelloWorldResource(StateService stateService) {
        this.stateService = stateService;
    }


    @GetMapping("/helloworld")
    public ResponseEntity<StateView> getHelloWorld() {
        System.out.println("TEST");
        Optional<StateView> stateOptional = stateService.findStateByAbbreviation("NY");
        if(stateOptional.isPresent()) {
            StateView state = stateOptional.get();
            return ResponseEntity.ok(state);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping(value="/helloworld")
    public ResponseEntity<StateView> postMethodName(@RequestBody StateView state) {
        Optional<StateView> stateOptional = stateService.findStateByAbbreviation("NY");
        if(stateOptional.isPresent()) {
            return ResponseEntity.ok(stateOptional.get());
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    
    }
    

}
