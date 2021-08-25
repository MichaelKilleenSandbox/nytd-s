/**
 * Filename: CohortRecord.java
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
package gov.hhs.acf.cb.nytds.persistence.component.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;


/**
 * @author Nava Krishna Mallela (23839)
 *
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "CohortStatusId"))
public class CohortStatus extends BaseEntityIdentity {

    @Getter
    @Setter
    @OneToMany(mappedBy = "cohortStatus")
    Collection<CohortRecord> cohortRecords;
    @Getter
    @Setter
    @Column(name = "COHORTSID")
    private Long cohortId;
    @Getter
    @Setter
    private Long stateId;
    @Getter
    @Setter
    private Long cohortSize;
    @Getter
    @Setter
    private Long sampleSize;
    @Getter
    @Setter
    private Long periodLocked19;
    @Getter
    @Setter
    private Long periodLocked21;

    public CohortStatus() {
    }

    public CohortStatus(Long id) {
        this.id = id;
    }

    public CohortStatus(Long id, Long cohortId, Long stateId, Long cohortSize, Long sampleSize, Long periodLocked19, Long periodLocked21, Collection<CohortRecord> cohortRecords) {
        this.id = id;
        this.cohortId = cohortId;
        this.stateId = stateId;
        this.cohortSize = cohortSize;
        this.sampleSize = sampleSize;
        this.periodLocked19 = periodLocked19;
        this.periodLocked21 = periodLocked21;
        this.cohortRecords = cohortRecords;

    }
}
