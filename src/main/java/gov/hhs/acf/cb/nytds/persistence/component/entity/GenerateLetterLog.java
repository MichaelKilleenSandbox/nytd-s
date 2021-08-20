package gov.hhs.acf.cb.nytds.persistence.component.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@ToString
@Builder(toBuilder = true)
public class GenerateLetterLog {

    @Getter
    @Setter
    private Long generateLetterLogId;
    @Getter
    @Setter
    @ManyToOne
    private Transmission transmission;
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
    private State state;
    @Getter
    @Setter
    @ManyToOne
    private SiteUser siteUser;
    @Getter
    @Setter
    private String complianceStatus;
    @Getter
    @Setter
    private LocalDateTime dateTimestamp;

}
