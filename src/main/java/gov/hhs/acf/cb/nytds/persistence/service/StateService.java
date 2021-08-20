package gov.hhs.acf.cb.nytds.persistence.service;

import gov.hhs.acf.cb.nytds.persistence.service.entity.Region;
import gov.hhs.acf.cb.nytds.persistence.service.entity.State;

import java.util.List;
import java.util.Optional;

public interface StateService {
    Optional<State> findStateByAbbreviation(String stateAbbreviation);

    Optional<State> findStateById(Long id);

    List<State> findStateByRegion(Region region);

    List<State> findStateByRegionId(Long id);
}
