package gov.hhs.acf.cb.nytds.persistence.state;

import gov.hhs.acf.cb.nytds.persistence.entity.Region;
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
}
