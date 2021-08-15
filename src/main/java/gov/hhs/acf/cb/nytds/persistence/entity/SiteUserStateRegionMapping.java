package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * SiteUserStateRegionMapping allows us to treat user's roles as first class objects in the system.
 * (gives us the ability to track created by info, etc.)
 */
@Entity
public class SiteUserStateRegionMapping extends BaseEntity
{
	@Getter	@Setter
	protected SiteUser siteUser;
	@Getter @Setter
	protected State state;

	public SiteUserStateRegionMapping()
	{
	}

	public SiteUserStateRegionMapping(Long siteUserStateRegionMappingId)
	{
		this.id = siteUserStateRegionMappingId;
	}
}