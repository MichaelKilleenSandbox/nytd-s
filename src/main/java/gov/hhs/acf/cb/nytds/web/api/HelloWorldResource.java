package gov.hhs.acf.cb.nytds.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @GetMapping("/helloworld")
    ResponseEntity<String> getHelloWorld() {
        System.out.println("TEST");
        return ResponseEntity.ok("Hello World");
    }

}
