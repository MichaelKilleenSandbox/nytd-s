package gov.hhs.acf.cb.nytds.persistence.entity;

import gov.hhs.acf.cb.nytds.util.DateUtil;
import java.text.DateFormat;
import lombok.Builder;

/**
* A class hold meta data for generated penalty letters model
*/

@Builder(toBuilder = true)
public class PenaltyLettersMetadata extends BaseEntity {

    private String fileName;
    private String status;
    private String reportingPeriods;
    private String states;
    private String transmissionIds;
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
