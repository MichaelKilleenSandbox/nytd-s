package gov.hhs.acf.cb.nytds.persistence.extendedduedate;

import gov.hhs.acf.cb.nytds.persistence.entity.ExtendedDueDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ExtendedDueDateRepository extends JpaRepository<ExtendedDueDate, Long>, ExtendedDueDateSearchAndFilterRepository {
}
