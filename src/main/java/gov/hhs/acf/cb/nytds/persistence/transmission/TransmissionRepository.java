package gov.hhs.acf.cb.nytds.persistence.transmission;

import gov.hhs.acf.cb.nytds.persistence.entity.ReportingPeriod;
import gov.hhs.acf.cb.nytds.persistence.entity.State;
import gov.hhs.acf.cb.nytds.persistence.entity.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface TransmissionRepository extends JpaRepository<Transmission, Long> {
    /**
     * Gets list of Transmission objects that are active ("current") submissions for a given state
     *
     * @param state state whose submissions are to be returned
     * @return list of Transmission objects that are active submissions
     */
    //List<Transmission> getActiveSubmittedTransmissions(State state);
    List<Transmission> findAllByStateAndSubmissionStatusEquals(State state, String status);
    List<Transmission> findAllByState_IdAndSubmissionStatusEquals(Long stateId, String status);


    /**
     * Gets list of Transmission objects that are active ("current") submissions for a given state and reporting period.
     * @param state state whose submissions are to be returned
     * @param reportingPeriod
     * @return list of Transmission objects that are active submissions
     */
    List<Transmission> findByStateAndReportingPeriodAndSubmissionStatus(State state, ReportingPeriod reportingPeriod, String status);

    List<Transmission> findByState_IdAndReportingPeriod_IdAndSubmissionStatusEquals(Long stateId, Long reportingPeriodId, String status);

    /**
     * Gets a transmission given its database identifier.
     *
     * @param id database identifier of the transmission to get
     * @return transmission with given database identifier
     */
    Optional<Transmission> findById(Long id);

    Transmission findTransmissionById(Long id);

}
