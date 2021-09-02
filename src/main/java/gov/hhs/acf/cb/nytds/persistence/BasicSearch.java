package gov.hhs.acf.cb.nytds.persistence;


import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: 13873
 * Date: Apr 20, 2010
 */
public class BasicSearch
{
	public static enum SortDirection
	{
		ASC, DESC
	}

	// sort association path (optional)
	// necessary to support Criteria API
	@Getter @Setter
	private String sortAssociation;

	// sort column
	@Getter @Setter
	private String sortColumn;

	// sort direction. default is ascending
	@Getter @Setter
	private SortDirection sortDirection = SortDirection.ASC;

	// transmissionId
	@Getter @Setter
	private Long transmissionId;

	// user performing the search
	@Getter @Setter
	SiteUser user;
	
	//non compliacne page name
	@Getter @Setter
	private String nonCompliancePageName;

	public void reset()
	{

	}
}
