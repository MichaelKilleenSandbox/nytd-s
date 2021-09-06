package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.entity.Message;
import gov.hhs.acf.cb.nytds.persistence.message.MessageSearch;
import gov.hhs.acf.cb.nytds.persistence.message.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MessageResource {

    private MessageService messageService;

    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id) {
        MessageSearch messageSearch = new MessageSearch();
        Optional<Message> message = messageService.getMessage(id);
        return ResponseEntity.ok(message.orElseThrow());
    }
}
