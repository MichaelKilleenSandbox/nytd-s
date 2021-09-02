package gov.hhs.acf.cb.nytds.persistence.compliance;

import gov.hhs.acf.cb.nytds.persistence.entity.ComplianceCategory;
import gov.hhs.acf.cb.nytds.persistence.entity.NytdError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ComplianceRepository extends JpaRepository<ComplianceCategory, Long> {

    static final String ERRORS_FOR_CATEGORIES_QUERY = "select error\n" +
            "            from NytdError error\n" +
            "                join error.complianceCategory\n" +
            "                join error.complianceCategory.complianceSuperCategory\n" +
            "                join error.nonCompliance\n" +
            "                left outer join error.nonCompliance.dataAggregate\n" +
            "                left outer join error.nonCompliance.dataAggregate.element\n" +
            "                join error.problemDescription\n" +
            "            where error.complianceCategory in (:categories) and error.nonCompliance.transmission.id = :transmissionId\n" +
            "            order by error.complianceCategory.id,error.nonCompliance.dataAggregate.element.id asc";


    List<ComplianceCategory> findComplianceCategoriesByAndComplianceSuperCategory_Name(String superCatName);

    @Query(value = "select coalesce(sum(error.complianceCategory.standardPenaltyValue), 0.0) from NytdError error where error.complianceCategory = :categoryId and error.nonCompliance.transmission.id = :transmissionId")
    BigDecimal findSumPenaltyForCategory(Long transmissionId, ComplianceCategory category);

    @Query(value="select coalesce(sum(error.complianceCategory.standardPenaltyValue), 0.0) from NytdError error where error.nonCompliance.transmission.id = :transmissionId")
    BigDecimal findSumPenaltyForTransmission(Long transmissionId);

    @Query(value="from ComplianceCategory cc where lower(cc.complianceSuperCategory.name) = 'data standards'")
    List<ComplianceCategory> findDataStandardsCategories();

    @Query(value = "from ComplianceCategory cc where cc.standardPenaltyValue is null")
    List<ComplianceCategory> findNonPenaltyCategories();

    @Query(value = "from ComplianceCategory cc where cc.standardPenaltyValue is not null and lower(cc.name) = 'error free information'")
    List<ComplianceCategory> findAggregateErrorCategories();

    @Query( value = "from ComplianceCategory cc where cc.standardPenaltyValue is not null and lower(cc.name) <> 'error free information'")
    List<ComplianceCategory> findTransmissionErrorCategories();

//    @Query(value = "select vwTr from VwTransmissionStatus vwTr where vwTr.transmissionId = :transmissionId")
//    List<VwTransmissionStatus> countDQAS(Long transmissionId);

    @Query(value="select count(distinct error) from NytdError error where error.complianceCategory = :category and error.nonCompliance.transmission.id = :transmissionId")
    Long findCountErrorsForCategory(Long transmissionId, ComplianceCategory category);

    @Query("select count(distinct error) from NytdError error where error.complianceCategory in (:categories) and error.nonCompliance.transmission.id = :transmissionId")
    Long findCountErrorsForCategories(Long transmissionId, List<ComplianceCategory> categories);

    @Query(value="from ComplianceCategory cc where lower(cc.complianceSuperCategory.name) = 'file submission standards'")
    List<ComplianceCategory> getFileSubmissionStandardsCategories();

    @Query(value=ERRORS_FOR_CATEGORIES_QUERY)
    List<NytdError> findErrorsForCategories(Long transmissionId, List<ComplianceCategory> categories);
}
