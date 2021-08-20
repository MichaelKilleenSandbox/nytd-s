package gov.hhs.acf.cb.nytds.persistence.component.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: 13873
 * Date: May 27, 2010
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "DataQualityAdvAggregateId"))
public class DataQualityAdvAggregate extends AggregateValue {
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "dataQualityAdvStandardId")
    private DataQualityAdvStandard dataQualityAdvStandard;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "transmissionId")
    private Transmission transmission;
    @Getter
    @Setter
    private String datumValue;


}
