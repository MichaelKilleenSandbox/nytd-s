/**
 * Filename: MessageRecipient.java
 * <p>
 * Copyright 2009, ICF International
 * Created: Sep 18, 2009
 * Author: 15178
 * <p>
 * COPYRIGHT STATUS: This work, authored by ICF International employees, was funded in whole or in part
 * under U.S. Government contract, and is, therefore, subject to the following license: The Government is
 * granted for itself and others acting on its behalf a paid-up, nonexclusive, irrevocable worldwide
 * license in this work to reproduce, prepare derivative works, distribute copies to the public, and perform
 * publicly and display publicly, by or on behalf of the Government. All other rights are reserved by the
 * copyright owner.
 */
package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.Calendar;

/**
 * @author 15178
 *
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "messagerecipientid"))
@SequenceGenerator(name = "default_gen", sequenceName = "SEQ_MESSAGERECIPIENT", allocationSize = BaseEntity.DEFAULT_SEQUENCE_ALLOCATION_SIZE)
public class MessageRecipient extends BaseEntity {
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "siteUserId")
    private SiteUser siteUser;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "messageId")
    private Message message;

    /**
     *
     */
    public MessageRecipient() {
        // TODO Auto-generated constructor stub
    }

    public MessageRecipient(Long messageRecipientId, SiteUser siteUser, Message message,
                            Calendar createdDate, String createdBy, Calendar updateDate, String updateBy, String description) {
        this.id = messageRecipientId;
        this.siteUser = siteUser;
        this.message = message;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.description = description;
    }

}
