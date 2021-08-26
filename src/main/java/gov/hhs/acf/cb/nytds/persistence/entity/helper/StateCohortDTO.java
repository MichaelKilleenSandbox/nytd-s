package gov.hhs.acf.cb.nytds.persistence.entity.helper;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class StateCohortDTO {
	@Getter @Setter private BigDecimal COHORTSID;
	@Getter @Setter private String NAME;
	@Getter @Setter private BigDecimal  SAMPLINGREQUESTID;
	@Getter @Setter private BigDecimal  REQUESTSTATUSID;
	@Getter @Setter private String  REQUESTSTATUS;
	@Getter @Setter private String REPORTYEAR17;
}
