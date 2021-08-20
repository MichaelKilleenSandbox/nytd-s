package gov.hhs.acf.cb.nytds.persistence.component.state;

import gov.hhs.acf.cb.nytds.persistence.component.entity.Region;
import gov.hhs.acf.cb.nytds.persistence.component.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface StateRepository extends JpaRepository<State, Long> {

    StateBusinessObject findStateByAbbreviation(String stateAbbreviation);

    StateView findStateById(Long id);

    List<StateView> findStateByRegion(Region region);

    List<StateView> findStateByRegionId(Long id);




}
