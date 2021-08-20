package gov.hhs.acf.cb.nytds.persistence.component.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * SiteUserSecondaryUserRole allows us to treat user's roles as first class objects in the system.
 * (gives us the ability to track created by info, etc.)
 */
@Entity
@Table(name = "SITEUSERSECONDARYROLE")
@AttributeOverride(name = "id", column = @Column(name = "SITEUSERSECONDARYROLEID"))
public class SiteUserSecondaryUserRole extends BaseEntity {
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "siteUserId")
    protected SiteUser siteUser;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "secondaryUserRoleId")
    protected SecondaryUserRole secondaryUserRole;

    public SiteUserSecondaryUserRole() {
    }

    public SiteUserSecondaryUserRole(Long siteUserSecondaryUserRoleId) {
        this.id = siteUserSecondaryUserRoleId;
    }
}