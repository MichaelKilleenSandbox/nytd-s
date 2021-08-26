/**
 *
 */
package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Calendar;

/**
 * @author 15178
 *
 */

 public class TransmissionDeleteLog implements Serializable {
    @Getter
    @Setter
    private Long transmissionId;
    @Getter
    @Setter
    @ManyToOne
    private TransmissionType transmissionType;
    @Getter
    @Setter
    @ManyToOne
    private ReportingPeriod reportingPeriod;
    @Getter
    @Setter
    private String complianceStatus;
    @Getter
    @Setter
    @ManyToOne
    private SiteUser siteUser;
    @Getter
    @Setter
    private String fileName;
    @Getter
    @Setter
    private Integer fileSize;
    @Getter
    @Setter
    private Calendar fileReceivedDate;
    @Getter
    @Setter
    private State state;
    @Getter
    @Setter
    private Calendar deletedDate;
    @Getter
    @Setter
    private String deletedBy;
    @Getter
    @Setter
    private Long recordCount;
    @Getter
    @Setter
    private String description;


    public TransmissionDeleteLog() {
    }

    public TransmissionDeleteLog(Long transmissionId) {
        this.transmissionId = transmissionId;
    }

    public TransmissionDeleteLog(Long transmissionId, TransmissionType transmissionType, ReportingPeriod reportingPeriod,
                                 Calendar deletedDate, String deletedBy, String complianceStatus, Calendar fileReceivedDate, SiteUser siteUser,
                                 String fileName, Integer fileSize, State state, Long recordCount) {
        this.transmissionId = transmissionId;
        this.transmissionType = transmissionType;
        this.reportingPeriod = reportingPeriod;
        this.deletedDate = deletedDate;
        this.deletedBy = deletedBy;
        this.siteUser = siteUser;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileReceivedDate = fileReceivedDate;
        this.state = state;
        this.recordCount = recordCount;
        this.complianceStatus = complianceStatus;

    }

}
