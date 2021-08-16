package gov.hhs.acf.cb.nytds.persistence.entity;

import gov.hhs.acf.cb.nytds.util.DateUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.text.DateFormat;

/**
 * A class hold meta data for generated penalty letters model
 */

@Builder(toBuilder = true)
@Entity
@AttributeOverride(name = "id", column = @Column(name = "PENALTYLETTERSMETADATAID"))
public class PenaltyLettersMetadata extends BaseEntity {

    @Getter @Setter
    private String fileName;
    @Getter @Setter
    private String status;
    @Getter @Setter
    private String reportingPeriods;
    @Getter @Setter
    private String states;
    @Getter @Setter
    private String transmissionIds;
    @Getter @Setter
    private String userName;

    // construtor with no arguments
    public PenaltyLettersMetadata() {
    }

    // constructor with id as an argument
    public PenaltyLettersMetadata(Long penaltyLettersMetadataId) {
        this.id = penaltyLettersMetadataId;
    }

    // constructor with all arguments
    public PenaltyLettersMetadata(String fileName, String status, String reportingPeriods,
                                  String states, String userName, String transmissionIds) {
        this.fileName = fileName;
        this.status = status;
        this.reportingPeriods = reportingPeriods;
        this.states = states;
        this.userName = userName;
        this.transmissionIds = transmissionIds;
    }


    public String getCreatedDateWithTimeStamp() {
        return DateUtil.formatDateAndTimezone(DateFormat.LONG, createdDate);
    }

    public void setTransmissionIds(String transmissionIds) {
        this.transmissionIds = transmissionIds;
    }

}
