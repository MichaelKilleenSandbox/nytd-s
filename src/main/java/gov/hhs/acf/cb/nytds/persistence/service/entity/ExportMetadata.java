package gov.hhs.acf.cb.nytds.persistence.service.entity;

import gov.hhs.acf.cb.nytds.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.text.DateFormat;

@Entity
public class ExportMetadata extends BaseEntity {
    @Getter
    @Setter
    private String fileName;
    @Getter
    @Setter
    private String fileType;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private String reportingPeriods;
    @Getter
    @Setter
    private String states;
    @Getter
    @Setter
    private String populations;
    @Getter
    @Setter
    private String demographics;
    @Getter
    @Setter
    private String characteristics;
    @Getter
    @Setter
    private String independentLivingServices;
    @Getter
    @Setter
    private String youthOutcomeSurveys;
    @Getter
    @Setter
    private String demographicNotes;
    @Getter
    @Setter
    private String characteristicNotes;
    @Getter
    @Setter
    private String independentLivingServiceNotes;
    @Getter
    @Setter
    private String youthOutcomeSurveyNotes;
    @Getter
    @Setter
    private String transmissionIds;
    @Getter
    @Setter
    private String userName;

    public ExportMetadata() {
    }

    public ExportMetadata(Long exportMetadataId) {
        this.id = exportMetadataId;
    }

    public String getCreatedDateWithTimeStamp() {
        return DateUtil.formatDateAndTimezone(DateFormat.LONG, createdDate);
    }


}
