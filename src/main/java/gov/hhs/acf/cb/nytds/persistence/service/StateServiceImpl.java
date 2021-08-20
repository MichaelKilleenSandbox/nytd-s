package gov.hhs.acf.cb.nytds.persistence.service;

import gov.hhs.acf.cb.nytds.persistence.service.entity.Region;
import gov.hhs.acf.cb.nytds.persistence.service.entity.State;
import gov.hhs.acf.cb.nytds.persistence.service.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
class StateServiceImpl implements StateService {
    private StateRepository stateRepository;

    StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }


    @Override
    public Optional<State> findStateByAbbreviation(String stateAbbreviation) {
        State state = stateRepository.findStateByAbbreviation(stateAbbreviation);
        return Optional.ofNullable(state);
    }

    @Override
    public Optional<State> findStateById(Long id) {
        State state = stateRepository.findStateById(id);
        return Optional.ofNullable(state);
    }

    @Override
    public List<State> findStateByRegion(Region region) {
        return Collections.unmodifiableList(stateRepository.findStateByRegion(region));
    }

    @Override
    public List<State> findStateByRegionId(Long id) {
        return Collections.unmodifiableList(stateRepository.findStateByRegionId(id));
    }
}
