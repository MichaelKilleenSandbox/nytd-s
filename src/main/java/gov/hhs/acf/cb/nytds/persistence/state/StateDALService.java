package gov.hhs.acf.cb.nytds.persistence.state;


import gov.hhs.acf.cb.nytds.persistence.entity.Region;
import gov.hhs.acf.cb.nytds.persistence.entity.State;

import java.util.List;
import java.util.Optional;

public interface StateDALService {

    List<State> findAllStates();

    Optional<StateView> findStateByAbbreviation(String stateAbbreviation);

    Optional<StateView> findStateById(Long id);

    List<StateView> findStateByRegion(Region region);

    List<StateView> findStateByRegionId(Long id);

    Optional<Region> findAssociatedRegion(String stateAbbreviation);

    List<State> findAssociatedStates(String stateAbbreviation);
}
