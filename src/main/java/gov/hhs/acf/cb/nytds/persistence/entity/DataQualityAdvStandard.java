package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

// Generated May 20, 2009 10:16:43 AM by Hibernate Tools 3.2.4.GA

/*
 * DataQualityAdvStandard generated by hbm2java
 */
@Entity
public class DataQualityAdvStandard extends BaseEntity
{
	@Getter @Setter
	private String name;
	@Getter @Setter
	private Integer dataQualityAdvStandard;

    // associations
	@Getter @Setter
	private AllowedValue allowedValue;

    // collections
	@Getter @Setter
    private Set<DataQualityAdvAggregate> dataAggregates =
            new HashSet<>();

	public DataQualityAdvStandard()
	{
	}

	public DataQualityAdvStandard(Long dataQualityAdvStandardId)
	{
		this.id = dataQualityAdvStandardId;
	}

	public DataQualityAdvStandard(Long dataQualityAdvStandardId, String name,
			Calendar createdDate, String createdBy, Calendar updateDate, String updateBy, String description)
	{
		this.id = dataQualityAdvStandardId;
		// this.element = element;
		this.name = name;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.description = description;
	}

}
