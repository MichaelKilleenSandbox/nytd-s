package gov.hhs.acf.cb.nytds.persistence.entity.helper;

import gov.hhs.acf.cb.nytds.persistence.entity.BaseEntityIdentity;
import gov.hhs.acf.cb.nytds.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.TimeZone;

// Generated Jun 10, 2009 3:28:47 PM by Hibernate Tools 3.2.4.GA
/*
 * Vwtransmissionstatus generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "VWTRANSMISSIONSTATUS")
@AttributeOverride(name = "id", column = @Column(name = "TRANSMISSIONID"))
public class VwTransmissionStatus extends BaseEntityIdentity
{
	@Getter @Setter
	private Long transmissionId;
	@Getter @Setter
	private Calendar submittedDate;
	@Getter @Setter
	private String fileGenerationDate;
	@Getter @Setter
	private Calendar fileReceivedDate;
	@Getter @Setter
	private String reportingPeriod;
	@Getter @Setter
	private Calendar endReportingDate;
	@Getter @Setter
	private String transmissionType;
	@Getter @Setter
	private BigDecimal potentialPenalty;
	@Getter @Setter
	private BigDecimal dataStandardPenalty;
	@Getter @Setter
	private BigDecimal fileStandardPenalty;
	@Getter @Setter
	private String state;
	@Getter @Setter
	private String region;
	@Getter @Setter
	private BigDecimal datValueCompliantCnt;
	@Getter @Setter
	private BigDecimal datValueDataQualtyAdvisCnt;
	@Getter @Setter
	private BigDecimal timelyErrCnt;
	@Getter @Setter
	private BigDecimal formatErrCnt;
	@Getter @Setter
	private BigDecimal recordLevelErrCnt;
	@Getter @Setter
	private BigDecimal transmissionLevelErrCnt;
	@Getter @Setter
	private String strFileReceivedDate;
	@Getter @Setter
	private String strSubmittedDate;
	@Getter @Setter
	private String complianceStatus;
	@Getter @Setter
	private String submissionStatus;
	@Getter @Setter
	private BigDecimal numberOfRecordsInFile;
	@Getter @Setter
	private String fileName;
	@Getter @Setter
	private String description;
	@Getter @Setter
	private String processingStatus;
	@Getter @Setter
	private String stateAbbr;

	//private String xmlTransmissionType;
	@Getter @Setter
	private String dataFileTransmissionTypeValue;
	@Getter @Setter
	private Long improperFormattedValCnt;
	@Getter @Setter
	private Integer elementLevelDQACnt;
	@Getter @Setter
	private Integer recordLevelDQACnt;

	public VwTransmissionStatus()
	{
	}

	/*
	 * 
	 */
	public VwTransmissionStatus(Long transmissionId)
	{
		this.transmissionId = transmissionId;
	}

	public VwTransmissionStatus(Long transmissionId, Boolean status, Calendar submittedDate,
			String fileGenerationDate, Calendar fileReceivedDate, String reportingPeriod,
			Calendar endReportingDate, String transmissionType, BigDecimal potentialPenalty, String state,
			String region, BigDecimal datValueCompliantCnt, BigDecimal datValueDataQualtyAdvisCnt,
			BigDecimal timelyErrCnt, BigDecimal formatErrCnt,BigDecimal fileStandardPenalty)
	{
		this.transmissionId = transmissionId;
		this.submittedDate = submittedDate;
		this.fileGenerationDate = fileGenerationDate;
		this.fileReceivedDate = fileReceivedDate;
		this.reportingPeriod = reportingPeriod;
		this.endReportingDate = endReportingDate;
		this.transmissionType = transmissionType;
		this.potentialPenalty = potentialPenalty;
		this.state = state;
		this.region = region;
		this.datValueCompliantCnt = datValueCompliantCnt;
		this.datValueDataQualtyAdvisCnt = datValueDataQualtyAdvisCnt;
		this.timelyErrCnt = timelyErrCnt;
		this.formatErrCnt = formatErrCnt;
		this.fileStandardPenalty = fileStandardPenalty;
	}


	/**
	 * @return the strFileReceivedDate
	 */
	public String getStrFileReceivedDate()
	{
		Calendar tempFileReceivedDate = fileReceivedDate;
		tempFileReceivedDate.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		strFileReceivedDate = DateUtil.getHourMintueSecondWithTimeZone(tempFileReceivedDate);

		return strFileReceivedDate;
	}

	/**
	 * @return the strFileSubmittedDateTime
	 */
	public String getStrSubmissionDateTime()
	{
		Calendar tempFileReceivedDate = submittedDate;
		tempFileReceivedDate.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		strSubmittedDate = DateUtil.getHourMintueSecondWithTimeZone(tempFileReceivedDate);
		return strSubmittedDate;
	}


	public String toString()
	{
		return getClass().getSimpleName() + "<" + Integer.toHexString(System.identityHashCode(this)) + ">"
				+ " id=" + getTransmissionId();
	}

	/**
	 * @return the xmlTransmissionType
	 */
	/*public String getXmlTransmissionType()
	{
		return xmlTransmissionType;
	}*/

	/**
	 * @param xmlTransmissionType the xmlTransmissionType to set
	 */
/*	public void setXmlTransmissionType(String xmlTransmissionType)
	{
		this.xmlTransmissionType = xmlTransmissionType;
	}*/

}
