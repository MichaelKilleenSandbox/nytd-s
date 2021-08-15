package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * SiteUserSecondaryUserRole allows us to treat user's roles as first class objects in the system.
 * (gives us the ability to track created by info, etc.)
 */
@Entity
public class SiteUserSecondaryUserRole extends BaseEntity {
    @Getter
    @Setter
    @ManyToOne
    protected SiteUser siteUser;
    @Getter
    @Setter
    @ManyToOne
    protected SecondaryUserRole secondaryUserRole;

    public SiteUserSecondaryUserRole() {
    }

    public SiteUserSecondaryUserRole(Long siteUserSecondaryUserRoleId) {
        this.id = siteUserSecondaryUserRoleId;
    }
}