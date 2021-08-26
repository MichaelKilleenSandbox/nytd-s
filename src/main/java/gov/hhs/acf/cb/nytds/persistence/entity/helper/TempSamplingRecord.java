package gov.hhs.acf.cb.nytds.persistence.entity.helper;

import gov.hhs.acf.cb.nytds.persistence.entity.BaseEntityIdentity;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
public class TempSamplingRecord extends BaseEntityIdentity
{
	@Getter @Setter private Long samplingRequestId;
	@Getter @Setter private String recordNumber;
	
	
	public TempSamplingRecord()
	{
	}

	/*
	 * 
	 */
	public TempSamplingRecord(Long id)
	{
		this.id = id;
	}

	public TempSamplingRecord(Long id ,Long samplingRequestId,String recordNumber)
	{
		this.id = id;
		this.samplingRequestId = samplingRequestId;
		this.recordNumber = recordNumber;
	}

}
