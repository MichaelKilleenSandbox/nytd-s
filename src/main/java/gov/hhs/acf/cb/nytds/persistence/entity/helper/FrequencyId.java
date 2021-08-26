package gov.hhs.acf.cb.nytds.persistence.entity.helper;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * Primary key for Frequency
 * 
 * @author Adam Russell (18816)
 * @see Frequency
 */
@Embeddable
@EqualsAndHashCode
public class FrequencyId implements Serializable
{
	@Getter @Setter private String state;
	@Getter @Setter private String reportPeriod;
	@Getter @Setter private String elementNumber;
	@Getter @Setter private String value;
}
