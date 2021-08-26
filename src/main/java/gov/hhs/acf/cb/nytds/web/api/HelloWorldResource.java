package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.state.StateService;
import gov.hhs.acf.cb.nytds.persistence.state.StateView;
import gov.hhs.acf.cb.nytds.persistence.transmission.TransmissionService;
import gov.hhs.acf.cb.nytds.persistence.transmission.TransmissionView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class HelloWorldResource {

    private StateService stateService;
    private TransmissionService transmissionService;

    public HelloWorldResource(StateService stateService, TransmissionService transmissionService) {
        this.stateService = stateService;
        this.transmissionService = transmissionService;
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

    @GetMapping("/helloworld2")
    public ResponseEntity<TransmissionView> getHelloWorld2() {

        System.out.println("TEST2");
        Optional<TransmissionView> transmissionOptional = transmissionService.findTransmissionWithId(2384L);
        if(transmissionOptional.isPresent()) {
            TransmissionView transmission = transmissionOptional.get();
            return ResponseEntity.ok(transmission);
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
