package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.reportingperiod.ReportingPeriodDALService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReportingPeriodResource {

    private ReportingPeriodDALService reportingPeriodDALService;

    public ReportingPeriodResource(ReportingPeriodDALService reportingPeriodDALService) {
        this.reportingPeriodDALService = reportingPeriodDALService;
    }

    @GetMapping("/reportingperiod")
    ResponseEntity<Map<String,String>> getReporingPeriod() {
        Map<String,String> theMap = reportingPeriodDALService.findReportingPeriodSelectMap();
        return ResponseEntity.ok(theMap);
    }

}
