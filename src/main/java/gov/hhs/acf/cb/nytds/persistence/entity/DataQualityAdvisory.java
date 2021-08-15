package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author 23839
 *
 */
@Entity
public class DataQualityAdvisory extends BaseEntity
{
	public static final String ELEMENT_ADVISORY ="ELEMENTLEVEL";
	public static final String RECORD_ADVISORY = "RECORDLEVEL";
	@Getter	@Setter
	protected Long transmissionId;
}
