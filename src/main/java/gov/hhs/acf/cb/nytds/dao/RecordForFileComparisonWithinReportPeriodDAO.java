package gov.hhs.acf.cb.nytds.dao;

import gov.hhs.acf.cb.nytds.persistence.entity.helper.RecordForFileComparisonWithinReportPeriod;

import java.util.List;


public interface RecordForFileComparisonWithinReportPeriodDAO
{
	List<RecordForFileComparisonWithinReportPeriod> getRecordsForFileComparisonWithinReportPeriod(
			Long transmission1Id, Long transmission2Id);
}
