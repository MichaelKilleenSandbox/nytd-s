package gov.hhs.acf.cb.nytds.persistence.component.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


//@Entity
//@AttributeOverride(name = "id", column = @Column(name = "RecordLevelAdvisoryId"))
public class RecordLevelAdvisory extends DataQualityAdvisory {
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "problemDescriptionId")
    private ProblemDescription problemDescription;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "datumId")
    private Datum datum;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "datumId")
    private Datum refDatum;
}
