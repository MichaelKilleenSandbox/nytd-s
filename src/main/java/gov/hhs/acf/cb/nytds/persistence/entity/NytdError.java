package gov.hhs.acf.cb.nytds.persistence.entity;

// Generated May 20, 2009 10:16:43 AM by Hibernate Tools 3.2.4.GA

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Calendar;


/*
 * NytdError originally generated by hbm2java
 *
 * @author 18816
 */
@Entity
public class NytdError extends BaseEntity {
    public static final String AGGREGATE_ERROR = "aggregateType";
    public static final String RECORD_ERROR = "recordLevel";

    @Getter
    @Setter
    protected String name;
    @Getter
    @Setter
    @ManyToOne
    protected ComplianceCategory complianceCategory;
    @Getter
    @Setter
    @ManyToOne
    protected ProblemDescription problemDescription;
    @Getter
    @Setter
    @ManyToOne
    protected NonCompliance nonCompliance;

    // reference element id and datum value used in the
    // record error messages for internal inconsistency checks
    @Getter
    @Setter
    protected Long referenceElementId;
    @Getter
    @Setter
    protected String referenceDatumValue;

    public NytdError() {
    }

    public NytdError(Long errorid) {
        this.id = errorid;
    }

    public NytdError(Long errorId, ProblemDescription problemDescription,
                     ComplianceCategory complianceCategory, NonCompliance nonCompliance, String name, Calendar createdDate,
                     String createdBy, Calendar updateDate, String updateBy, String description) {
        this.id = errorId;
        this.problemDescription = problemDescription;
        this.complianceCategory = complianceCategory;
        this.nonCompliance = nonCompliance;
        this.name = name;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.description = description;
    }


    public String formatErrorMessage() {
        if (problemDescription == null) {
            return "N/A";
        }
        return problemDescription.getName();
    }
}
