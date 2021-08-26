package gov.hhs.acf.cb.nytds.persistence.entity;

import gov.hhs.acf.cb.nytds.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.AttributeOverride;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import java.text.DateFormat;

@Entity
public class ExportMetadata extends BaseEntity {
@AttributeOverride(name = "id", column = @Column(name = "ExportMetaDataId"))
@SequenceGenerator(name = "default_gen", sequenceName = "SEQ_EXPORTMETADATA", allocationSize = BaseEntity.DEFAULT_SEQUENCE_ALLOCATION_SIZE)
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
