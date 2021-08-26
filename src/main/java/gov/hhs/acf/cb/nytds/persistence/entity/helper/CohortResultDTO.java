package gov.hhs.acf.cb.nytds.persistence.entity.helper;

import lombok.Getter;
import lombok.Setter;

public class CohortResultDTO {
	@Getter @Setter private String e3RecordNumber;
	@Getter @Setter private Long transmissionId;
	@Getter @Setter private Long recordId;
	@Getter @Setter private String reportingPeriod;
}
