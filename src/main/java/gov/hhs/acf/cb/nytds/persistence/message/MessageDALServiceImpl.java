package gov.hhs.acf.cb.nytds.persistence.message;

import gov.hhs.acf.cb.nytds.persistence.entity.*;
import gov.hhs.acf.cb.nytds.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.DateFormat;
import java.util.*;

@Service
class MessageDALServiceImpl implements MessageDALService {

    private static final String CREATED_DATE = "createdDate";
    // Spring mail sender used to send email notifications
    private JavaMailSender mailSender;
    // template email message
    private SimpleMailMessage mailTemplate;
    protected final Logger log = Logger.getLogger(getClass());

    private MessageRepository messageRepository;
    private MessageRecipientRepository messageRecipientRepository;
    private SystemGeneratedMessageRepository systemGeneratedMessageRepository;

    MessageDALServiceImpl(MessageRepository messageRepository, MessageRecipientRepository messageRecipientRepository, SystemGeneratedMessageRepository systemGeneratedMessageRepository) {

        this.messageRepository = messageRepository;
        this.messageRecipientRepository = messageRecipientRepository;
        this.systemGeneratedMessageRepository = systemGeneratedMessageRepository;
    }


    @Override
    public Message createSystemMessage(String type, Map<String, Object> namedParams) {
        // create the system message
        Message msg = new Message();
        prepareSystemMessage(msg);
        Optional<SystemGeneratedMessage> result = getMessageTemplate(type);
        if(result.isPresent()) {
            SystemGeneratedMessage msgTemplate = result.get();
            String msgSubject = msgTemplate.getSubject();
            String msgBody = msgTemplate.getSystemMessageBody();
            if (namedParams != null) {
                msgSubject = msgTemplate.formatText(msgSubject, namedParams);
                msgBody = msgTemplate.formatText(msgBody, namedParams);
            }

            msg.setSubject(msgSubject);
            msg.setMessageBody(msgBody);
            msg.setDescription(msgTemplate.getDescription());
        }

        return msg;
    }

    @Override
    public Message prepareSystemMessage(Message systemMsg) {
        NYTDSystem nytdSystem = new NYTDSystem();
        systemMsg.setMessageFrom(nytdSystem.getName());
        systemMsg.setSignature(nytdSystem.getSignature());
        systemMsg.setBeforeSignatureWord(nytdSystem.getBeforSignatureWord());

        return systemMsg;
    }

    @Override
    public MessageSearch search(MessageSearch search) {
        return messageRepository.search(search);
    }


    @Override
    public void sendEmailNotification(Message systemMsg, List<String> emailAddresses) {
        boolean isHtml = true;
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageBuilder = new MimeMessageHelper(mimeMessage);
            for (String to : emailAddresses) {
                messageBuilder.addTo(new InternetAddress(to));
            }
            messageBuilder.setFrom(mailTemplate.getFrom());
            messageBuilder.setSubject(systemMsg.getSubject());
            StringBuilder messageText = new StringBuilder();
            messageText.append(systemMsg.getMessageBody());
            messageText.append("<br><br>");
            messageText.append(systemMsg.getBeforeSignatureWord()).append(",");
            messageText.append("<br>");
            messageText.append(systemMsg.getSignature());
            messageBuilder.setText(messageText.toString(), isHtml);

            mailSender.send(messageBuilder.getMimeMessage());

        }
        catch (MessagingException e) {
            log.error("Messaging Exception in sendEmailNotification: " + e.getMessage(), e);
        }
        catch (MailException e) {
            log.error("Mail Exception in sendEmailNotification: " + e.getMessage(), e);
        }
    }

    @Override
    public void sendSystemMessage(Message msg, SiteUser recipients) {
        List<SiteUser> siteUserList = new ArrayList<>();
        siteUserList.add(recipients);
        sendSystemMessage(msg,siteUserList);
    }

    @Override
    public void sendSystemMessage(Message msg, List<SiteUser> recipients) {
        messageRepository.saveAndFlush(msg);

        // create list of email addresses of users requesting email notification
        // while saving each recipient to the database
        List<String> emailAddresses = new ArrayList<>();
        for (SiteUser user : recipients) {
            MessageRecipient recipient = new MessageRecipient();
            recipient.setSiteUser(user);
            recipient.setMessage(msg);
            recipient.setUpdateDate(Calendar.getInstance());
            messageRecipientRepository.save(recipient);

            // add user to email address list if email notification requested
            if (!user.isDeleted() && user.isReceiveEmailNotifications() && user.getEmailAddress() != null) {
                emailAddresses.add(user.getEmailAddress());
            }
        }

        // send e-mail notification to users requesting it
        if (!emailAddresses.isEmpty()) {
            sendEmailNotification(msg, emailAddresses);
        }
    }

    @Override
    public void sendRequiredSystemMessage(Message msg, List<SiteUser> recipients) {
        msg.setCreatedDate(new GregorianCalendar());
        messageRepository.save(msg);

        recipients.stream()
                .filter(Objects::nonNull)
                .filter(u -> !u.isDeleted())
                .filter(u -> u.getEmailAddress() != null)
                .forEach(u -> saveAndSendEmail(u, msg));

    }

    private void saveAndSendEmail(SiteUser user, Message msg) {

        MessageRecipient recipient = new MessageRecipient();
        recipient.setSiteUser(user);
        recipient.setMessage(msg);
        messageRecipientRepository.save(recipient);

        sendEmailNotification(msg, Collections.singletonList(user.getEmailAddress()));
    }

    @Override
    public Message sendMessage(Message msg, List<SiteUser> recipients) {

        // save messsage
        msg.setCreatedDate(new GregorianCalendar());
        messageRepository.save(msg);

        // create list of email addresses of users requesting email notification
        // while saving each recipient to the database
        List<String> emailAddresses = new ArrayList<>();
        for (SiteUser user : recipients) {
            MessageRecipient recipient = new MessageRecipient();
            recipient.setSiteUser(user);
            recipient.setMessage(msg);
            messageRecipientRepository.save(recipient);

            // add user to email address list if email notification requested
            if (user.isReceiveEmailNotifications() && user.getEmailAddress() != null && !(user.isDeleted())) {
                emailAddresses.add(user.getEmailAddress());
            }
        }

        // send e-mail notification to users requesting it
        if (!emailAddresses.isEmpty()) {
            sendEmailNotification(msg, emailAddresses);
        }

        return msg;
    }

    /**
     * @see MessageDALService#getMessage(Long)
     * @return
     */
    @Override
    public Optional<Message> getMessage(Long messageId) {

        Optional<Message> result = messageRepository.findById(messageId);

        if(result.isPresent()) {

            if (result.get().getCreatedDate() != null) {
                Calendar cal = result.get().getCreatedDate();
                result.get().setMessageCreatedDate(DateUtil.formatDateAndTimezone(DateFormat.LONG, cal));
            }
            return result;
        }
        return Optional.empty();


    }

    /**
     * Get message template based on type.
     *
     * @param type as String
     * @return SystemGeneratedMessage object
     */
    private Optional<SystemGeneratedMessage> getMessageTemplate(String type) {
        // prepare named query

        Optional<SystemGeneratedMessage> result = systemGeneratedMessageRepository
                .findSystemGeneratedMessageByDescriptionContainingIgnoreCase(type);

        return result;
    }
}
