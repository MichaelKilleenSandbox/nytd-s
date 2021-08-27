package gov.hhs.acf.cb.nytds.persistence.state;

import gov.hhs.acf.cb.nytds.persistence.entity.Region;
import gov.hhs.acf.cb.nytds.persistence.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface StateRepository extends JpaRepository<State, Long> {

    StateView findStateByAbbreviation(String stateAbbreviation);

    StateView findStateById(Long id);

    List<StateView> findByOrderByStateNameAsc();

    List<StateView> findStateByRegionId(Long id);

    @Query("SELECT s.region FROM State s WHERE s.abbreviation = :stateAbbreviation")
    Region findAssociatedRegion(String stateAbbreviation);

    @Query("SELECT s.region.states FROM State s WHERE s.abbreviation = :stateAbbreviation")
    List<State> findAssociatedStates(String stateAbbreviation);
}
