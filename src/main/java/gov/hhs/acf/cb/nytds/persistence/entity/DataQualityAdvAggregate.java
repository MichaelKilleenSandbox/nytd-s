package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: 13873
 * Date: May 27, 2010
 */
@Entity
public class DataQualityAdvAggregate extends AggregateValue {
    @Getter @Setter
    private DataQualityAdvStandard dataQualityAdvStandard;
    @Getter @Setter
    private Transmission transmission;
    @Getter @Setter
    private String datumValue;


}
