package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.compliance.ComplianceService;
import gov.hhs.acf.cb.nytds.persistence.entity.ComplianceCategory;
import gov.hhs.acf.cb.nytds.persistence.entity.NytdError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ComplianceResource {
    private ComplianceService complianceService;

    public ComplianceResource(ComplianceService complianceService) {
        this.complianceService = complianceService;
    }

    @GetMapping("/compliance/nonpenaltycategories")
    public ResponseEntity<List<ComplianceCategory>> getNonPenaltyCategories() {
        List<ComplianceCategory> complianceCategories = complianceService.getNonPenaltyCategories();
        return ResponseEntity.ok(complianceCategories);
    }

    @GetMapping("/compliance/aggregateerrorcategories")
    public ResponseEntity<List<ComplianceCategory>> getAggregateErrorCategories() {
        List<ComplianceCategory> complianceCategories = complianceService.getAggregateErrorCategories();
        return ResponseEntity.ok(complianceCategories);
    }

    @GetMapping("/compliance/recordErrorCategories")
    public ResponseEntity<List<ComplianceCategory>> getRecordErrorCategories() {
        List<ComplianceCategory> complianceCategories = complianceService.getRecordErrorCategories();
        return ResponseEntity.ok(complianceCategories);
    }

    @GetMapping("/compliance/dataStandardsCategories")
    public ResponseEntity<List<ComplianceCategory>> getDataStandardsCategories() {
        List<ComplianceCategory> complianceCategories = complianceService.getDataStandardsCategories();
        return ResponseEntity.ok(complianceCategories);
    }

    @GetMapping("/compliance/transmissionErrorCategories")
    public ResponseEntity<List<ComplianceCategory>> getTransmissionErrorCategories() {
        List<ComplianceCategory> complianceCategories = complianceService.getTransmissionErrorCategories();
        return ResponseEntity.ok(complianceCategories);
    }

    @GetMapping("/compliance/fileSubmissionStandardsCategories")
    public ResponseEntity<List<ComplianceCategory>> getFileSubmissionStandardsCategories() {
        List<ComplianceCategory> complianceCategories = complianceService.getFileSubmissionStandardsCategories();
        return ResponseEntity.ok(complianceCategories);
    }

    @GetMapping("/compliance/calcFileSubmissionPenalty/{transmissionId}")
    public ResponseEntity<Double> getCalcFileSubmissionPenalty(@PathVariable("transmissionId") Long transmissionId) {
        Double penalty = complianceService.calcFileSubmissionPenalty(transmissionId);
        return ResponseEntity.ok(penalty);
    }

    @GetMapping("/compliance/transmissionIsCompliant/{transmissionId}")
    public ResponseEntity<Boolean> getIsCompliant(@PathVariable("transmissionId") Long transmissionId) {
        Boolean compliant = complianceService.isCompliant(transmissionId);
        return ResponseEntity.ok(compliant);
    }

    @GetMapping("/compliance/errorsForCategories/{transmissionId}")
    public ResponseEntity<List<NytdError>> getErrorsForCategories(@PathVariable("transmissionId") Long transmissionId) {
        List<ComplianceCategory> categories = complianceService.findAllComplianceCatories();
        List<NytdError> complianceCategories = complianceService.getErrorsForCategories(transmissionId, Collections.emptyList());
        return ResponseEntity.ok(complianceCategories);
    }



}
