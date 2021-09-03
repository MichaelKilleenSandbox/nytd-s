package gov.hhs.acf.cb.nytds.persistence.compliance;

public interface ComplianceSearchRepository {
    ComplianceSearch searchDataAggregates(ComplianceSearch search);
    PenaltySearch searchAggregatePenalties(PenaltySearch search);
}
