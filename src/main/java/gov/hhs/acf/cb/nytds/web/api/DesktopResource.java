package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.entity.ReportingPeriod;
import gov.hhs.acf.cb.nytds.persistence.entity.VwExtendedDueDate;
import gov.hhs.acf.cb.nytds.persistence.extendedduedate.ExtendedDueDateDALService;
import gov.hhs.acf.cb.nytds.persistence.extendedduedate.ExtendedDueDateSearch;
import gov.hhs.acf.cb.nytds.persistence.message.MessageDALService;
import gov.hhs.acf.cb.nytds.service.transmission.TransmissionServiceP3;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DesktopResource {

    private MessageDALService messageDALService;
    private TransmissionServiceP3 transmissionServiceP3;
    private ExtendedDueDateDALService extendedDueDateDALService;

    public DesktopResource(MessageDALService messageDALService, TransmissionServiceP3 transmissionServiceP3, ExtendedDueDateDALService extendedDueDateDALService) {
        this.messageDALService = messageDALService;
        this.transmissionServiceP3 = transmissionServiceP3;
        this.extendedDueDateDALService = extendedDueDateDALService;
    }

    @GetMapping("/desktop")
    ResponseEntity<List<VwExtendedDueDate>> getDesktop() {

        // calculate the days, hours and minutes remaining for submission
        Calendar today = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        Optional<ReportingPeriod> reportPeriod = transmissionServiceP3.getCurrentReportingPeriod();
        if (reportPeriod.isPresent()) {
            Calendar deadline = transmissionServiceP3.getSubmissionDeadline(reportPeriod.get());

            long delta = deadline.getTimeInMillis() - today.getTimeInMillis();
            long millisPerDay = 1000 * 60 * 60 * 24;
            long millisPerHour = 1000 * 60 * 60;
            long millisPerMin = 1000 * 60;
            long days = delta / millisPerDay;
            long hours = (delta - (days * millisPerDay)) / millisPerHour;
            long mins = (delta - (days * millisPerDay) - (hours * millisPerHour)) / millisPerMin;

            // set the countdown message
            List messageArgs = Arrays.asList(days, hours, mins, reportPeriod.get().getName());
            // TODO mjk Add back in. countdownMessage = getText("submission.countdownMessage", messageArgs);
        }

        //check for current extended due dates
        Calendar date = transmissionServiceP3.getSubmissionDeadline(reportPeriod.orElseThrow());

        ExtendedDueDateSearch eddSearch = new ExtendedDueDateSearch(date);

        eddSearch.setPageSize(0);

        List<VwExtendedDueDate> vwExtendedDueDateList = extendedDueDateDALService.getExtendedDueDateData(eddSearch);

        return ResponseEntity.ok(vwExtendedDueDateList);
    }

}
