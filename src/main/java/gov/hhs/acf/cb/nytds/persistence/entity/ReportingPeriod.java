package gov.hhs.acf.cb.nytds.persistence.entity;

// Generated May 20, 2009 10:16:43 AM by Hibernate Tools 3.2.4.GA

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

/*
 * ReportingPeriod generated by hbm2java
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "REPORTINGPERIODID"))
@SequenceGenerator(name = "default_gen", sequenceName = "SEQ_REPORTINGPERIOD", allocationSize = BaseEntity.DEFAULT_SEQUENCE_ALLOCATION_SIZE)
public class ReportingPeriod extends BaseEntity implements Serializable {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Calendar startReportingDate;
    @Getter
    @Setter
    private Calendar endReportingDate;
    @Getter
    @Setter
    private Integer outcomeAge;
    @Getter
    @Setter
    @OneToMany(mappedBy = "reportingPeriod")
    private Set<DueDate> dueDates;
    @Getter
    @Setter
    @JsonManagedReference
    @OneToMany(mappedBy = "reportingPeriod")
    private Set<Transmission> transmissions;
    @Getter
    @Setter
    private String endRptDateStr;
    @Getter
    @Setter
    private String startRptDateStr;
    @Getter
    @Setter
    private String correctedFileEndRptDateStr;

    public ReportingPeriod() {
    }

    public ReportingPeriod(Long reportingPeriodId) {
        this.id = reportingPeriodId;
    }

    public ReportingPeriod(Long reportingPeriodId, String name, Calendar startReportingDate,
                           Calendar endReportingDate, Calendar createdDate, String createdBy, Calendar updateDate,
                           String updateBy, String description, Set<DueDate> dueDates, Set<Transmission> transmissions, String endRptDateStr, String startRptDateStr) {
        this.id = reportingPeriodId;
        this.name = name;
        this.startReportingDate = startReportingDate;
        this.endReportingDate = endReportingDate;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.description = description;
        this.dueDates = dueDates;
        this.transmissions = transmissions;
        this.endRptDateStr = endRptDateStr;
        this.startRptDateStr = startRptDateStr;
    }

}
