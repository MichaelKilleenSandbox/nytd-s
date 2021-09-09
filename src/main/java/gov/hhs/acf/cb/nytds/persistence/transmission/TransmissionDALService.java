package gov.hhs.acf.cb.nytds.persistence.transmission;

import gov.hhs.acf.cb.nytds.persistence.entity.*;
import gov.hhs.acf.cb.nytds.persistence.entity.helper.VwNote;
import gov.hhs.acf.cb.nytds.persistence.entity.helper.VwTransmissionStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TransmissionDALService {
    /**
     * Gets list of Transmission objects that are active ("current") submissions for a given state
     *
     * @param state state whose submissions are to be returned
     * @return list of Transmission objects that are active submissions
     */
    List<Transmission> findActiveSubmittedTransmissions(State state);

    /**
     * Gets list of Transmission objects that are active ("current") submissions for a given state and reporting period.
     * @param state state whose submissions are to be returned
     * @param reportingPeriod
     * @return list of Transmission objects that are active submissions
     */
    List<Transmission> findActiveSubmittedTransmissions(State state, Long reportingPeriod);

    List<Transmission> findActiveSubmittedTransmissions(State state, ReportingPeriod reportingPeriod);

    /**
     * Gets a transmission given its database identifier.
     *
     * @param id database identifier of the transmission to get
     * @return transmission with given database identifier
     */
    Optional<Transmission> findTransmissionWithId(Long id);


    /**
     * Returns map containing transmission ids and "file numbers"
     * corresponding to given state and report period
     *
     * @param stateId id of state for which to return transmissions
     * @param reportPeriodId id of report period for which to return transmissions
     * @return map containing transmission ids and "file numbers"
     */
    Map<String, String> findTransmissionSelectMap(Long stateId, Long reportPeriodId);

    /**
     * Returns map containing transmission ids and "file numbers"
     * corresponding to given site user
     *
     * @param siteUser site user for which to return transmissions
     * @return map containing transmission ids and "file numbers"
     */
    Map<String, String> findTransmissionSelectMap(SiteUser siteUser);

    /**
     * Returns number of transmissions in a given report period for a given state.
     *
     * @param stateId id of state
     * @param reportPeriodId id of report period
     * @param onlySubmissions whether or not to count only submissions
     * @return number of transmissions
     */
    Long findTransmissionCount(Long stateId, Long reportPeriodId, Boolean onlySubmissions);

    /**
     * Delete all transmissions.
     */
    void deleteAll();

    void deleteTransmission(Transmission transmission);

    /**
     * Return transmission with highest id.
     * @return transmission with highest id
     */
    Transmission findWithHighestId();

    /**
     * To update transmission's processingStatus
     * before invoking rules engine
     * Return Transmission
     * @param transmisssion
     * @return
     */
    Transmission updateTransmissionProcessingStatus(Transmission transmisssion);

    /**
     * To update transmission
     * @param transmission as Transmission object
     */
    void updateTransmission(Transmission transmission) ;

    /**
     * Get submission status (Active/Inactive) for a single transmission
     * @param transmissionId
     * @return
     */
    Optional<String> findSubmissionStatus(Long transmissionId);

    /**
     * Get transmission type (Regular/Corrected/Subsequent/Test) for a single transmission
     * @param transmissionId
     * @return
     */
    Optional<String> findTransmissionType(Long transmissionId);

    /**
     * Get compliance status (Compliant/Non-Compliant) for a single transmission
     * @return Compliant or non-compliant
     */
    Optional<String> findComplianceStatus(Long transmissionId);

    List<VwTransmissionStatus> findVwTransmissionStatus(TransmissionSearch search);

    List<TransmissionRecord> findRecordNotes(TransmissionSearch search);

    List<VwNote> findDatumNotes(TransmissionSearch search);
}
