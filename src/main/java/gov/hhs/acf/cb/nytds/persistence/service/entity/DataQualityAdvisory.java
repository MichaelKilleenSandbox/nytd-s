package gov.hhs.acf.cb.nytds.persistence.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author 23839
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "DataQualityAdvisoryId"))
public class DataQualityAdvisory extends BaseEntity {
    public static final String ELEMENT_ADVISORY = "ELEMENTLEVEL";
    public static final String RECORD_ADVISORY = "RECORDLEVEL";
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "transmissionId")
    protected Transmission transmission;
}
