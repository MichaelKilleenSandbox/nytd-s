package gov.hhs.acf.cb.nytds.persistence.entity;

import gov.hhs.acf.cb.nytds.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class ElementLevelAdvisory extends DataQualityAdvisory {
    @Getter
    @Setter
    private Integer countValue;
    @Getter
    @Setter
    private BigDecimal percentValue;
    @Getter
    @Setter
    private String elementLevelDatumValue;
    @Getter
    @Setter
    @ManyToOne
    private ElementLevelDQAStandard elementLevelDQAStandard;


    public String toYYYYMMDD(String ddMMMyy) {
        return DateUtil.toYYYYMMDD(ddMMMyy);
    }

}
