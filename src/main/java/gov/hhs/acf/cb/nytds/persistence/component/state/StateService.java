package gov.hhs.acf.cb.nytds.persistence.component.state;

import gov.hhs.acf.cb.nytds.persistence.component.entity.Region;

import java.util.List;
import java.util.Optional;

public interface StateService {
    Optional<StateBusinessObject> findStateByAbbreviation(String stateAbbreviation);

    Optional<StateView> findStateById(Long id);

    List<StateView> findStateByRegion(Region region);

    List<StateView> findStateByRegionId(Long id);

}
