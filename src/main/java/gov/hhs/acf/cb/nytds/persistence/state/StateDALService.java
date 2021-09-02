package gov.hhs.acf.cb.nytds.persistence.state;


import gov.hhs.acf.cb.nytds.persistence.entity.Region;
import gov.hhs.acf.cb.nytds.persistence.entity.State;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StateDALService {

    List<State> findAllStates();

    Page<StateView> findAllStates(int pageNumber, int pageSize);

    Optional<StateView> findStateByAbbreviation(String stateAbbreviation);

    Optional<StateView> findStateById(Long id);

    List<StateView> findStateByRegion(Long regionId);

    List<StateView> findStateByRegionId(Long id);

    Optional<Region> findAssociatedRegion(String stateAbbreviation);

    List<State> findAssociatedStates(String stateAbbreviation);

    Map<String, Long> instanceOfStateAbbrevIdMap();

    Map<Long, String> instanceOfStateSelectMap();

    Map<String, String> instanceOfStateAbbrevMap();

    Optional<String> findStateAbbr(String stateName);

    Optional<Long> findStateIdByAbbr(String abbreviation);
}
