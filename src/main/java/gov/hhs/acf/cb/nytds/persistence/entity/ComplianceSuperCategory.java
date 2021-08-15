package gov.hhs.acf.cb.nytds.persistence.entity;

// Generated May 20, 2009 10:16:43 AM by Hibernate Tools 3.2.4.GA

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/*
 * ComplianceSuperCategory generated by hbm2java
 */
@Entity
public class ComplianceSuperCategory extends BaseEntity
{
	@Getter	@Setter
	private String name;
	@Getter @Setter
	private Set<ComplianceCategory> complianceCategories = new HashSet<>(0);

	public ComplianceSuperCategory()
	{
	}

	public ComplianceSuperCategory(Long complianceSuperCategoryId)
	{
		this.id = complianceSuperCategoryId;
	}

	public ComplianceSuperCategory(Long complianceSuperCategoryId, String name, Calendar createdDate,
			String createdBy, Calendar updateDate, String updateBy, String description,
			Set<ComplianceCategory> complianceCategories)
	{
		this.id = complianceSuperCategoryId;
		this.name = name;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.description = description;
		this.complianceCategories = complianceCategories;
	}

}
