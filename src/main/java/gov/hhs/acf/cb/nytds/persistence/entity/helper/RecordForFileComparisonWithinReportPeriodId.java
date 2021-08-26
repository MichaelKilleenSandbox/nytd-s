package gov.hhs.acf.cb.nytds.persistence.entity.helper;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * Primary key for RecordForFileComparisonWithinReportPeriod.
 * 
 * @author Adam Russell (18816)
 * @see RecordForFileComparisonWithinReportPeriod
 */
@Embeddable
@EqualsAndHashCode
public class RecordForFileComparisonWithinReportPeriodId implements Serializable
{
	@Getter @Setter private String recordNumber;
	@Getter @Setter private Long transmissionId;
	@Getter @Setter private Boolean matched;
	@Getter @Setter private Boolean changed;
	@Getter @Setter private Boolean inError;
}
