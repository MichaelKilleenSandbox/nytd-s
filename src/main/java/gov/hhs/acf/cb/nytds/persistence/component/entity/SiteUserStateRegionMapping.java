package gov.hhs.acf.cb.nytds.persistence.component.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * SiteUserStateRegionMapping allows us to treat user's roles as first class objects in the system.
 * (gives us the ability to track created by info, etc.)
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "SiteUserStateRegionMappingId"))
@SequenceGenerator(name = "default_gen", sequenceName = "SEQ_SITEUSERSTATERGN", allocationSize = BaseEntity.DEFAULT_SEQUENCE_ALLOCATION_SIZE)
public class SiteUserStateRegionMapping extends BaseEntity {
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "siteUserId")
    protected SiteUser siteUser;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "stateId")
    protected State state;

    public SiteUserStateRegionMapping() {
    }

    public SiteUserStateRegionMapping(Long siteUserStateRegionMappingId) {
        this.id = siteUserStateRegionMappingId;
    }
}