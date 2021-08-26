package gov.hhs.acf.cb.nytds.persistence.state;


import gov.hhs.acf.cb.nytds.persistence.entity.Region;

import java.util.List;
import java.util.Optional;

public interface StateService {

    Optional<StateView> findStateByAbbreviation(String stateAbbreviation);

    Optional<StateView> findStateById(Long id);

    List<StateView> findStateByRegion(Region region);

    List<StateView> findStateByRegionId(Long id);

}
