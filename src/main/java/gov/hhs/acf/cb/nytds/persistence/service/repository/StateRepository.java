package gov.hhs.acf.cb.nytds.persistence.service.repository;

import gov.hhs.acf.cb.nytds.persistence.service.entity.Region;
import gov.hhs.acf.cb.nytds.persistence.service.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    State findStateByAbbreviation(String stateAbbreviation);

    State findStateById(Long id);

    List<State> findStateByRegion(Region region);

    List<State> findStateByRegionId(Long id);

}
