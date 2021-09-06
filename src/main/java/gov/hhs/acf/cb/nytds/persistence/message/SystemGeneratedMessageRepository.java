package gov.hhs.acf.cb.nytds.persistence.message;

import gov.hhs.acf.cb.nytds.persistence.entity.SystemGeneratedMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemGeneratedMessageRepository extends JpaRepository<SystemGeneratedMessage, Long> {

    //  from SystemGeneratedMessage msg  where lower(msg.description) like ('%' || lower(:type) || '%')

    Optional<SystemGeneratedMessage> findSystemGeneratedMessageByDescriptionContainingIgnoreCase(String type);

}
