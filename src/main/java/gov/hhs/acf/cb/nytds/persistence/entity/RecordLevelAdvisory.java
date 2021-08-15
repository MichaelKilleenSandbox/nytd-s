package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class RecordLevelAdvisory extends DataQualityAdvisory {
    @Getter
    @Setter
    @ManyToOne
    private ProblemDescription problemDescription;
    @Getter
    @Setter
    @ManyToOne
    private Datum datum;
    @Getter
    @Setter
    @ManyToOne
    private Datum refDatum;
}
