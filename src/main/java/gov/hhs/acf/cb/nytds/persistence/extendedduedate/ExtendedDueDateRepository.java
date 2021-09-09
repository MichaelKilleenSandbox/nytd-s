package gov.hhs.acf.cb.nytds.persistence.extendedduedate;

import gov.hhs.acf.cb.nytds.persistence.entity.ExtendedDueDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ExtendedDueDateRepository extends JpaRepository<ExtendedDueDate, Long>, ExtendedDueDateSearchAndFilterRepository {

    List<ExtendedDueDate> findExtendedDueDatesByState_id(Long id);
}
