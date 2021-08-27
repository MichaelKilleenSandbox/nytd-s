package gov.hhs.acf.cb.nytds.persistence.state;

import gov.hhs.acf.cb.nytds.persistence.entity.Region;
import gov.hhs.acf.cb.nytds.persistence.entity.State;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class StateDALServiceImpl implements StateDALService {
    private StateRepository stateRepository;
    // Instance variables to avoid needless trips to the DB.
    private Map<Long, String> mapOfIdAndStateName;
    private Map<String, Long> mapOfAbbreviationAndId;
    private Map<String, String> mapOfStateNameAndAbbreviation;

    StateDALServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<State> findAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public Optional<StateView> findStateByAbbreviation(String stateAbbreviation) {
        StateView state = stateRepository.findStateByAbbreviation(stateAbbreviation);
        return Optional.ofNullable(state);
    }

    @Override
    public Optional<StateView> findStateById(Long id) {
        StateView state = stateRepository.findStateById(id);
        return Optional.ofNullable(state);
    }

    @Override
    public List<StateView> findStateByRegion(Long regionId) {
        return Collections.unmodifiableList(stateRepository.findStateByRegionId(regionId));
    }

    @Override
    public List<StateView> findStateByRegionId(Long id) {
        return Collections.unmodifiableList(stateRepository.findStateByRegionId(id));
    }

    @Override
    public Optional<Region> findAssociatedRegion(String stateAbbreviation) {
        return Optional.ofNullable(stateRepository.findAssociatedRegion(stateAbbreviation));
    }

    @Override
    public List<State> findAssociatedStates(String stateAbbreviation) {
        List<State> states = stateRepository.findAssociatedStates(stateAbbreviation);
        return states;
    }

    @Override
    public Map<Long, String> instanceOfStateSelectMap() {

        if (this.mapOfIdAndStateName == null) {
            List<StateView> states = stateRepository.findByOrderByStateNameAsc();
            this.mapOfIdAndStateName = new LinkedHashMap<>();
            states.forEach(stateView -> this.mapOfIdAndStateName.put(stateView.getId(), stateView.getStateName()));
        }
        return Collections.unmodifiableMap(this.mapOfIdAndStateName);
    }

    @Override
    public Map<String, String> instanceOfStateAbbrevMap() {
        if (this.mapOfStateNameAndAbbreviation == null) {
            List<StateView> states = stateRepository.findByOrderByStateNameAsc();
            this.mapOfStateNameAndAbbreviation = new LinkedHashMap<>();
            states.forEach(stateView -> this.mapOfStateNameAndAbbreviation.put(stateView.getStateName(), stateView.getAbbreviation()));
        }
        return Collections.unmodifiableMap(this.mapOfStateNameAndAbbreviation);
    }

    @Override
    public Map<String, Long> instanceOfStateAbbrevIdMap() {
        if (this.mapOfAbbreviationAndId == null) {
            List<StateView> states = stateRepository.findByOrderByStateNameAsc();
            this.mapOfAbbreviationAndId = new LinkedHashMap<>();
            states.forEach(stateView -> this.mapOfAbbreviationAndId.put(stateView.getAbbreviation(), stateView.getId()));
        }
        return Collections.unmodifiableMap(this.mapOfAbbreviationAndId);
    }

    @Override
    public Optional<String> findStateAbbr(String stateName) {
        return Optional.ofNullable(instanceOfStateAbbrevMap().get(stateName));
    }

    @Override
    public Optional<Long> findStateIdByAbbr(String abbreviation) {
        return Optional.ofNullable(this.mapOfAbbreviationAndId.get(abbreviation));
    }
}
