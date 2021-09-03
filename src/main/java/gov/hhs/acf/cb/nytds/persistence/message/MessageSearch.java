package gov.hhs.acf.cb.nytds.persistence.message;

import gov.hhs.acf.cb.nytds.persistence.BasicSearch;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: 13873
 * Date: Apr 20, 2010
 */
public class MessageSearch extends BasicSearch
{
	// search criteria
	@Getter @Setter private String messageCreatedStartDate;
	@Getter @Setter private String messageCreatedEndDate;
	@Getter @Setter private String text;

	public void reset()
	{
		super.reset();
		setMessageCreatedStartDate(null);
		setMessageCreatedEndDate(null);
		setText(null);
	}
}
