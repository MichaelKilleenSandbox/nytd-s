package gov.hhs.acf.cb.nytds.persistence.reportingperiod;

import gov.hhs.acf.cb.nytds.persistence.entity.ReportingPeriod;
import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class ReportingPeriodDALServiceImpl implements ReportingPeriodDALService {
    private ReportingPeriodRepository reportingPeriodRepository;

    ReportingPeriodDALServiceImpl(ReportingPeriodRepository reportingPeriodRepository) {
        this.reportingPeriodRepository = reportingPeriodRepository;
    }

    /**
     * @return
     */
    @Override
    public Optional<String> findReportPeriodName(Long reportPeriodId) {
        Optional<ReportingPeriod> queryResult = reportingPeriodRepository.findById(reportPeriodId);
        return queryResult.map(ReportingPeriod::getName);
    }

    /**
     * @return
     */
    @Override
    public Optional<ReportingPeriod> findPreviousOutcomesReportingPeriod(ReportingPeriod reportPeriod) {
        assert (reportPeriod != null);

        if (reportPeriod.getOutcomeAge() == null) {
            return Optional.empty();
        }

        // In order to most accurately query for the period 2 years prior,
        // a range of plus or minus seven days will be applied.
        Calendar lowDateBoundary = (Calendar) reportPeriod.getEndReportingDate().clone();
        lowDateBoundary.add(Calendar.DAY_OF_YEAR, -7);
        Calendar highDateBoundary = (Calendar) reportPeriod.getEndReportingDate().clone();
        highDateBoundary.add(Calendar.DAY_OF_YEAR, 7);

        lowDateBoundary.add(Calendar.YEAR, -2);
        highDateBoundary.add(Calendar.YEAR, -2);

        // Get the previous outcomes reporting period.

        List<ReportingPeriod> previousReportPeriods = reportingPeriodRepository
                .findByEndReportingDateGreaterThanAndEndReportingDateLessThan(lowDateBoundary, highDateBoundary);

        if (previousReportPeriods.isEmpty()) {
            return Optional.empty();
        }
        assert (previousReportPeriods.size() == 1);
        return Optional.of(previousReportPeriods.get(0));
    }

    /**
     * @return
     * @author Adam Russell (18816)
     */
    @Override
    public Optional<ReportingPeriod> findEnsuingReportPeriod(ReportingPeriod reportPeriod) {
        assert (reportPeriod != null);

        List<ReportingPeriod> ensuingReportPeriods =
                reportingPeriodRepository
                        .findByEndReportingDateGreaterThanOrderByEndReportingDateAsc(reportPeriod.getEndReportingDate());

        // Get the report period directly following the given report period.
//        query = "from ReportingPeriod as reportPeriod "
//                + "where reportPeriod.endReportingDate > to_date('%1$td-%1$tb-%1$ty') "
//                + "order by reportPeriod.endReportingDate asc";
        if (ensuingReportPeriods.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(ensuingReportPeriods.get(0));

    }

    /**
     * @return
     * @author Adam Russell (18816)
     */
    @Override
    public Optional<ReportingPeriod> findPrecedingReportPeriod(ReportingPeriod reportPeriod) {
        assert (reportPeriod != null);

        List<ReportingPeriod> previousReportPeriods =
                reportingPeriodRepository
                        .findByEndReportingDateLessThanOrderByEndReportingDateDesc(reportPeriod.getEndReportingDate());

        // Get the report period directly preceding the given report period.
//        query = "from ReportingPeriod as reportPeriod "
//                + "where reportPeriod.endReportingDate < to_date('%1$td-%1$tb-%1$ty') "
//                + "order by reportPeriod.endReportingDate desc";
//
        if (previousReportPeriods.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(previousReportPeriods.get(0));
    }

    /**
     * @author Adam Russell (18816)
     */
    @Override
    public Map<String, String> findReportingPeriodSelectMap() {
        Calendar now = new GregorianCalendar();
        now.setTime(new Date());
        // TODO mjk 8/27/2021 flagging this TODO. What's going on here???
        now.set(2019, 10, 1); // TODO: Remove this line. We are developing for the future currently.

        List<ReportingPeriodView> reportingPeriodViews = reportingPeriodRepository.findReportingPeriodsByStartReportingDateLessThanEqualOrderByEndReportingDate(now);

//        query = "select reportPeriod.id, reportPeriod.name "
//                + "from ReportingPeriod as reportPeriod "
//                + "where reportPeriod.startReportingDate <= :startDate "
//                + "order by reportPeriod.endReportingDate desc ";

        final Map<String, String> selectMap = new LinkedHashMap<>();
        reportingPeriodViews.forEach(reportingPeriodView -> {
            selectMap.put(String.valueOf(reportingPeriodView.getId()), reportingPeriodView.getName());
        });
        return Collections.unmodifiableMap(selectMap);
    }

    /**
     * @author Adam Russell (18816)
     */
    @Override
    public Map<String, String> findReportPeriodSelectMapForUser(
            SiteUser siteUser, Integer minimumTransmissions) {
        String userRole = siteUser.getPrimaryUserRole().getDescription();

        List<ReportingPeriodView> reportingPeriodViews;

        if (userRole.equals("State")) {
            reportingPeriodViews = reportingPeriodRepository.findStaeUserReportingPeriodMap(minimumTransmissions, siteUser.getState().getId());
        } else if (userRole.equals("Regional")) {
            reportingPeriodViews = reportingPeriodRepository.findRegionUserReportingPeriodMap(minimumTransmissions, siteUser.getRegion().getId());
        } else {
            reportingPeriodViews = reportingPeriodRepository.findDefaultUserReportingPeriodMap(minimumTransmissions);
        }

        final Map<String, String> selectMap = new LinkedHashMap<>();
        reportingPeriodViews.forEach(reportingPeriodView -> {
            selectMap.put(String.valueOf(reportingPeriodView.getId()), reportingPeriodView.getName());
        });

        return Collections.unmodifiableMap(selectMap);
    }

    /**
     * @author Adam Russell (18816)
     */
    @Override
    public Map<String, String> findReportPeriodSelectMapForUser(SiteUser siteUser) {
        return findReportPeriodSelectMapForUser(siteUser, 1);
    }

    /**
     * @return
     */
    @Override
    public Optional<Long> findReportingPeriodIdByName(String reportingPeriodName) {

        ReportingPeriodView reportingPeriodView = reportingPeriodRepository.findReportingPeriodsByName(reportingPeriodName);
        if (reportingPeriodView != null) {
            return Optional.of(reportingPeriodView.getId());
        }
        return Optional.empty();
    }

    @Override
    public Optional<ReportingPeriod> findCurrentReportingPeriod() {
        Calendar targetDate = Calendar.getInstance();
        targetDate.add(Calendar.DATE, -45);
        return Optional.ofNullable(reportingPeriodRepository.findReportingPeriodForDate(targetDate));
    }

    @Override
    public Optional<ReportingPeriod> currentReportingPeriodForState(long daysDifference) {
        return reportingPeriodRepository.findReportingPeriodForState(45 + daysDifference);
    }

    @Override
    public Optional<ReportingPeriod> currentCorrectedReportingPeriodForState(long daysDifference) {
        return reportingPeriodRepository.findCurrentCorrectedReportingPeriodForState(45 + daysDifference);
    }


}
