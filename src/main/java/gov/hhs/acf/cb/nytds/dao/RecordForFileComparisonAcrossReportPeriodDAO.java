package gov.hhs.acf.cb.nytds.dao;


import gov.hhs.acf.cb.nytds.persistence.entity.helper.FileAdvisoryAcrossReportPeriods;

import java.util.List;

public interface RecordForFileComparisonAcrossReportPeriodDAO {
        List<FileAdvisoryAcrossReportPeriods> getRecordsForFileComparisonAcrossReportPeriod(
            Long transmissionId, Long siteUserId);
}

