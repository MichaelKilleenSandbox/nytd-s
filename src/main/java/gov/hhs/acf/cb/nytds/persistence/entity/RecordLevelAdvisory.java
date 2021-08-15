package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Entity
public class RecordLevelAdvisory extends DataQualityAdvisory
{
	@Getter	@Setter
	private ProblemDescription problemDescription;
	@Getter @Setter
	private Datum datum;
	@Getter @Setter
	private Datum refDatum;
}
