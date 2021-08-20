package gov.hhs.acf.cb.nytds.persistence.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * SiteUserStateRegionMapping allows us to treat user's roles as first class objects in the system.
 * (gives us the ability to track created by info, etc.)
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "SiteUserStateRegionMappingId"))
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