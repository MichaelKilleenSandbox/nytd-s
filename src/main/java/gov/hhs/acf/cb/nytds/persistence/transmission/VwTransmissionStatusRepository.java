package gov.hhs.acf.cb.nytds.persistence.transmission;

import gov.hhs.acf.cb.nytds.persistence.entity.helper.VwTransmissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface VwTransmissionStatusRepository extends JpaRepository<VwTransmissionStatus, Long>, VwTransmissionStatusRepo {


}
