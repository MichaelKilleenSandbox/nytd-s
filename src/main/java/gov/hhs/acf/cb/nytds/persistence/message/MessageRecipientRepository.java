package gov.hhs.acf.cb.nytds.persistence.message;

import gov.hhs.acf.cb.nytds.persistence.entity.MessageRecipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRecipientRepository extends JpaRepository<MessageRecipient, Long> {
}
