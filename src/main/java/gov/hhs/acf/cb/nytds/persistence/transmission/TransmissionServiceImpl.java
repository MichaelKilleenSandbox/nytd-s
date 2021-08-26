package gov.hhs.acf.cb.nytds.persistence.transmission;

import gov.hhs.acf.cb.nytds.persistence.entity.ReportingPeriod;
import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;
import gov.hhs.acf.cb.nytds.persistence.entity.State;
import gov.hhs.acf.cb.nytds.persistence.entity.Transmission;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
class TransmissionServiceImpl implements TransmissionService {

    private TransmissionRepository transmissionRepository;

    TransmissionServiceImpl(TransmissionRepository transmissionRepository) {
        this.transmissionRepository = transmissionRepository;
    }

    @Override
    public List<Transmission> findActiveSubmittedTransmissions(State state) {
        //return transmissionRepository.findAllByStateAndSubmissionStatusEquals(state, "Active");
        return transmissionRepository.findAllByState_IdAndSubmissionStatusEquals(state.getId(), "Active");
    }

    @Override
    public List<Transmission> findActiveSubmittedTransmissions(State state, Long reportingPeriod) {
        return null;
    }

    @Override
    public List<Transmission> findActiveSubmittedTransmissions(State state, ReportingPeriod reportingPeriod) {
        return transmissionRepository
                .findByState_IdAndReportingPeriod_IdAndSubmissionStatusEquals(state.getId(), reportingPeriod.getId(), "Active");
    }

    @Override
    public Optional<Transmission> findTransmissionWithId(Long id) {
        return Optional.ofNullable(transmissionRepository.findTransmissionById(id));
    }

    @Override
    public Map<String, String> findTransmissionSelectMap(Long stateId, Long reportPeriodId) {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, String> findTransmissionSelectMap(SiteUser siteUser) {
        throw new NotImplementedException();
    }

    @Override
    public Long findTransmissionCount(Long stateId, Long reportPeriodId, Boolean onlySubmissions) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteAll() {
        throw new NotImplementedException();
    }

    @Override
    public Transmission findWithHighestId() {
        throw new NotImplementedException();
    }

    @Override
    public Transmission updateTransmissionProcessingStatus(Transmission transmisssion) {
        throw new NotImplementedException();
    }

    @Override
    public void updateTransmission(Transmission transmission) {
        throw new NotImplementedException();
    }

    @Override
    public Optional<String> findSubmissionStatus(Long transmissionId) {
        Optional<Transmission> transmissionOptional = transmissionRepository.findById(transmissionId);
        if(transmissionOptional.isPresent()) {
            return Optional.ofNullable(transmissionOptional.get().getSubmissionStatus());
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> findTransmissionType(Long transmissionId) {
        Optional<Transmission> transmissionOptional = transmissionRepository.findById(transmissionId);
        if(transmissionOptional.isPresent()) {
            return Optional.ofNullable(transmissionOptional.get().getTransmissionType().getName());
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> findComplianceStatus(Long transmissionId) {
        Optional<Transmission> transmissionOptional = transmissionRepository.findById(transmissionId);
        if(transmissionOptional.isPresent()) {
            return Optional.ofNullable(transmissionOptional.get().getComplianceStatus());
        }
        return Optional.empty();
    }
}
