package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by IntelliJ IDEA.
 * User: 13873
 * Date: May 27, 2010
 */
@Entity
public class DataQualityAdvAggregate extends AggregateValue {
    @Getter
    @Setter
    @ManyToOne
    private DataQualityAdvStandard dataQualityAdvStandard;
    @Getter
    @Setter
    @ManyToOne
    private Transmission transmission;
    @Getter
    @Setter
    private String datumValue;


}
