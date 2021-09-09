package gov.hhs.acf.cb.nytds.persistence.transmission;

import gov.hhs.acf.cb.nytds.persistence.entity.*;
import gov.hhs.acf.cb.nytds.persistence.entity.helper.VwNote;
import gov.hhs.acf.cb.nytds.persistence.entity.helper.VwTransmissionStatus;
import gov.hhs.acf.cb.nytds.util.UserRoleEnum;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
class TransmissionDALServiceImpl implements TransmissionDALService {

    private TransmissionRepository transmissionRepository;
    private VwTransmissionStatusRepository transmissionStatusRepository;
    private DatumRepository datumRepository;

    TransmissionDALServiceImpl(TransmissionRepository transmissionRepository, VwTransmissionStatusRepository transmissionStatusRepository, DatumRepository datumRepository) {
        this.transmissionRepository = transmissionRepository;
        this.transmissionStatusRepository = transmissionStatusRepository;
        this.datumRepository = datumRepository;
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
    public void deleteTransmission(Transmission transmission) {
        transmissionRepository.deleteById(transmission.getId());
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

    @Override
    public List<VwTransmissionStatus> findVwTransmissionStatus(TransmissionSearch search) {

        UserRoleEnum role = UserRoleEnum.getRole(search.getUser().getPrimaryUserRole().getName());

        List<VwTransmissionStatus> vwTransmissionStatuses = Collections.emptyList();

        switch (role) {
            case ADMIN:
            case FEDERAL:
                vwTransmissionStatuses = transmissionStatusRepository.findVwTransmissionStatusByAdminFedRole(role);
                break;
            case REGIONAL:

                vwTransmissionStatuses = transmissionStatusRepository.findVwTransmissionStatusByRegionalRole(search.getUser().getRegion().getRegion());
                break;
            case STATE:
                vwTransmissionStatuses = transmissionStatusRepository.findVwTransmissionStatusByStateRole(search.getUser().getState().getStateName());
                break;
        }
        return vwTransmissionStatuses;
    }


    @Override
    public List<TransmissionRecord> findRecordNotes(TransmissionSearch search) {
        return null;
    }

    @Override
    public List<VwNote> findDatumNotes(TransmissionSearch search) {

        List<VwNote> datumList = datumRepository.findDatumNotes(search.getTransmissionId());
        // TODO mjk 9/8/2021 Finish this method.
        return datumList;

//        Query qry = getSessionFactory().getCurrentSession().getNamedQuery("getDatumNotes");
//        qry.setParameter("transmissionId", search.getTransmissionId());
//
//        // return all records with datum notes
//        List<VwNote> results = qry.list();
//
//        // sort the results. we handle the sorting
//        // here because the named query (native sql
//        // optimized for performance) cannot accept
//        // an order by clause dynamically
//        final String sortColumn = search.getSortColumn();
//        final PaginatedSearch.SortDirection sortDirection = search.getSortDirection();
//        if (sortColumn != null) {
//            results.sort(new TransmissionServiceP3Impl.NoteComparator(search));
//            if (sortDirection == PaginatedSearch.SortDirection.DESC) {
//                Collections.reverse(results);
//            }
//        }
//
//        search.setPageResults(results);
//        return search;

    }
}
