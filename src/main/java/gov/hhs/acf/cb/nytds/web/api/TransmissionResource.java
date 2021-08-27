package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.transmission.TransmissionDALService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TransmissionResource {
    private TransmissionDALService transmissionDALService;

    public TransmissionResource(TransmissionDALService transmissionDALService) {
        this.transmissionDALService = transmissionDALService;
    }

    @GetMapping("/transmission")
    ResponseEntity<String> getTransmissions() {
        Optional<String> optionalComplianceStatus = transmissionDALService.findComplianceStatus(2385L);
        if(optionalComplianceStatus.isPresent()) {
            return ResponseEntity.ok(optionalComplianceStatus.get());
        }
        return ResponseEntity.badRequest().build();
    }
 }
