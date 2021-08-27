package gov.hhs.acf.cb.nytds.persistence.reportingperiod;

import gov.hhs.acf.cb.nytds.persistence.entity.ReportingPeriod;
import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;

import java.util.Map;
import java.util.Optional;

public interface ReportingPeriodDALService {
    /**
     * Get name of report period given an id.
     *
     * @param reportPeriodId id of report period
     * @return name of report period
     */
    Optional<String> findReportPeriodName(Long reportPeriodId);

    /**
     * Gets the outcomes reporting period previous to the given report period.
     *
     * @param reportPeriod the report period for which to find the previous outcomes reporting period
     * @return the previous outcomes reporting period, or null if one wasn't found
     */
    Optional<ReportingPeriod> findPreviousOutcomesReportingPeriod(ReportingPeriod reportPeriod);

    /**
     * Gets the report period directly ensuing the given report period.
     *
     * @param reportPeriod the report period for which to find the ensuing report period
     * @return the ensuing report period, or null if one wasn't found
     */
    Optional<ReportingPeriod> findEnsuingReportPeriod(ReportingPeriod reportPeriod);

    /**
     * Gets the report period directly preceding the given report period.
     *
     * @param reportPeriod the report period for which to find the preceding report period
     * @return the preceding report period, or null if one wasn't found
     */
    Optional<ReportingPeriod> findPrecedingReportPeriod(ReportingPeriod reportPeriod);

    /**
     * Returns map containing past reporting period ids and names.
     * @return map containing past reporting period ids and names
     */
    Map<String, String> findReportingPeriodSelectMap();

    /**
     * Returns map containing reporting period ids and names of those that contain transmissions.
     *
     * @param siteUser siteUser for which to return report periods
     * @param minimumTransmissions minimum number of transmissions/submissions in the report periods
     * @return map containing reporting period ids and names
     */
    Map<String, String> findReportPeriodSelectMapForUser(
            SiteUser siteUser, Integer minimumTransmissions);

    /**
     * Returns map containing reporting period ids and names of those that contain transmissions.
     *
     * @param siteUser siteUser for which to return report periods
     * @return map containing reporting period ids and names
     */
    Map<String, String> findReportPeriodSelectMapForUser(SiteUser siteUser);

    /**
     * Get reporting period id by name.
     *
     * @param reportingPeriodName reporting period name
     * @return id of reporting period
     */
    Optional<Long> findReportingPeriodIdByName(String reportingPeriodName);
}
