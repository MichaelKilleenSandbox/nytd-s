package gov.hhs.acf.cb.nytds.persistence.message;

import gov.hhs.acf.cb.nytds.persistence.entity.Message;
import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;

import java.util.List;
import java.util.Map;

public class MessageServiceImpl implements MessageService {
    @Override
    public Message createSystemMessage(String type, Map<String, Object> namedParams) {
        return null;
    }

    @Override
    public Message prepareSystemMessage(Message msg) {
        return null;
    }

    @Override
    public MessageSearch search(MessageSearch search) {
        return null;
    }

    @Override
    public void sendEmailNotification(Message systemMsg, List<String> emailAddresses) {

    }

    @Override
    public void sendSystemMessage(Message msg, SiteUser recipient) {

    }

    @Override
    public void sendSystemMessage(Message msg, List<SiteUser> recipients) {

    }

    @Override
    public void sendRequiredSystemMessage(Message msg, List<SiteUser> recipients) {

    }

    @Override
    public Message sendMessage(Message msg, List<SiteUser> recipients) {
        return null;
    }

    @Override
    public Message getMessage(Long messageId) {
        return null;
    }
}
