/**
 * Filename: Cohort.java
 * <p>
 * Copyright 2009, ICF International
 * Created: Jun 27, 2012
 * Author: 23839
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Calendar;
import java.util.Set;


/**
 * @author Nava Krishna Mallela (23839)
 *
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "SamplingRequestId"))
@SequenceGenerator(name = "default_gen", sequenceName = "SEQ_SAMPLINGREQUEST", allocationSize = BaseEntity.DEFAULT_SEQUENCE_ALLOCATION_SIZE)
public class SamplingRequest extends BaseEntity {

    @Getter
    @Setter
    @OneToMany(mappedBy = "samplingRequest")
    Set<SamplingRequestHistory> samplingRequestHistory;
    @Getter
    @Setter
    private Long cohortStatusId;
    @Getter
    @Setter
    private String samplingMethod;
    @Getter
    @Setter
    private Long samplingRequestStatusId;
    @Getter
    @Setter
    private Long importStatusId;
    @Getter
    @Setter
    private String importSummary;
    @Getter
    @Setter
    private Calendar samplingStatusDate;

    public SamplingRequest() {
    }

    public SamplingRequest(Long id) {
        this.id = id;
    }

    public SamplingRequest(Long id, Long cohortStatusId, String samplingMethod, Long samplingRequestStatusId, Long importStatusId,
                           String importSummary, Calendar samplingStatusDate, Set<SamplingRequestHistory> samplingRequestHistory) {
        this.id = id;
        this.cohortStatusId = cohortStatusId;
        this.samplingMethod = samplingMethod;
        this.samplingRequestStatusId = samplingRequestStatusId;
        this.importStatusId = importStatusId;
        this.importSummary = importSummary;
        this.samplingStatusDate = samplingStatusDate;
        this.samplingRequestHistory = samplingRequestHistory;
    }
}
