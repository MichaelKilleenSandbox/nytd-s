package gov.hhs.acf.cb.nytds.persistence.state;

import gov.hhs.acf.cb.nytds.persistence.entity.Region;
import gov.hhs.acf.cb.nytds.persistence.entity.State;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
class StateDALServiceImpl implements StateDALService {
    private StateRepository stateRepository;

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
    public List<StateView> findStateByRegion(Region region) {
        return Collections.unmodifiableList(stateRepository.findStateByRegion(region));
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
    public List<State> findAssociatedStates(String stateAbbreviation)  {
        List<State> states = stateRepository.findAssociatedStates(stateAbbreviation);
        return states;
    }
}
