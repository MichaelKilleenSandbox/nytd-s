package gov.hhs.acf.cb.nytds.persistence.reportingperiod;

import gov.hhs.acf.cb.nytds.persistence.entity.ReportingPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
interface ReportingPeriodRepository extends JpaRepository<ReportingPeriod, Long> {

    final String THE_QUERY_STATE = "select reportPeriod.id, reportPeriod.name "
            + "from ReportingPeriod as reportPeriod "
            + "join reportPeriod.transmissions as transmission "
            + "join transmission.state as state "
            + "where state.id = :stateId "
            + "group by reportPeriod.id, reportPeriod.name, reportPeriod.endReportingDate "
            + "having count(transmission) >= :minimumTransmissions "
            + "order by reportPeriod.endReportingDate desc ";


    final String THE_QUERY_REGION = "select reportPeriod.id, reportPeriod.name "
            + "from ReportingPeriod as reportPeriod "
            + "join reportPeriod.transmissions as transmission "
            + "join transmission.state as state "
            + "where state.id in (select state.id from State as state join state.region as region where region.id = :regionId) and ("
            + "transmission.submissionStatus = 'Active' or "
            + "transmission.submissionStatus = 'Inactive') "
            + "group by reportPeriod.id, reportPeriod.name, reportPeriod.endReportingDate "
            + "having count(transmission) >= :minimumTransmissions "
            + "order by reportPeriod.endReportingDate desc ";

    final String THE_QUERY_OTHER = "select reportPeriod.id, reportPeriod.name "
            + "from ReportingPeriod as reportPeriod "
            + "join reportPeriod.transmissions as transmission "
            + "join transmission.state as state "
            + "where transmission.submissionStatus = 'Active' or "
            + "transmission.submissionStatus = 'Inactive' "
            + "group by reportPeriod.id, reportPeriod.name, reportPeriod.endReportingDate "
            + "having count(transmission) >= :minimumTransmissions "
            + "order by reportPeriod.endReportingDate desc ";



    List<ReportingPeriod> findByEndReportingDateGreaterThanAndEndReportingDateLessThan(Calendar lowDateBoundary, Calendar highDateBoundary);
    List<ReportingPeriod> findByEndReportingDateGreaterThanOrderByEndReportingDateAsc(Calendar dateBoundary);
    List<ReportingPeriod> findByEndReportingDateLessThanOrderByEndReportingDateDesc(Calendar endReportingDate);
    List<ReportingPeriodView> findReportingPeriodsByStartReportingDateLessThanEqualOrderByEndReportingDate(Calendar now);
    ReportingPeriodView findReportingPeriodsByName(String reportPeriodName);

    @Query(THE_QUERY_STATE)
    List<ReportingPeriodView> findStaeUserReportingPeriodMap(Integer minimumTransmissions, Long stateId);

    @Query(THE_QUERY_REGION)
    List<ReportingPeriodView> findRegionUserReportingPeriodMap(Integer minimumTransmissions, Long regionId);

    @Query(THE_QUERY_OTHER)
    List<ReportingPeriodView> findDefaultUserReportingPeriodMap(Integer minimumTransmissions);




}
