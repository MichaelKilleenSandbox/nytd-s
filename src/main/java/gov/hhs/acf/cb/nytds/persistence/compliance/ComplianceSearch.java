package gov.hhs.acf.cb.nytds.persistence.compliance;

import gov.hhs.acf.cb.nytds.persistence.BasicSearch;
import gov.hhs.acf.cb.nytds.persistence.entity.ComplianceCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 13873
 * Date: Apr 20, 2010
 */
public class ComplianceSearch extends BasicSearch
{
	@Getter @Setter
	private List<String> recordNumbers;
	@Getter @Setter
	private String elementNumber;
	@Getter @Setter
	private String elementName;
	@Getter @Setter
	private String complianceType;
	@Getter @Setter
	private Long datumId;
	@Getter @Setter
	private List<ComplianceCategory> nonPenaltyCategories;

	public ComplianceSearch()
	{
		super();
		loadDefaults();
	}



	public void reset()
	{
		loadDefaults();
	}

	private void loadDefaults()
	{
		setRecordNumbers(new ArrayList<String>());
		setElementNumber("All");
		setElementName("");
		setComplianceType("All");
		setNonPenaltyCategories(new ArrayList());
	}

	/**
	 * @return the datumId
	 */
	public Long getDatumId()
	{
		return datumId;
	}

	/**
	 * @param datumId the datumId to set
	 */
	public void setDatumId(Long datumId)
	{
		this.datumId = datumId;
	}
}
