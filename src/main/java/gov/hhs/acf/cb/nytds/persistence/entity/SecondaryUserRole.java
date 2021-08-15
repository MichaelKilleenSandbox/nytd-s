package gov.hhs.acf.cb.nytds.persistence.entity;

// Generated May 20, 2009 10:16:43 AM by Hibernate Tools 3.2.4.GA

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/*
 * SecondaryUserRole generated by hbm2java
 */
@Entity
public class SecondaryUserRole extends BaseEntity {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @OneToMany
    private Set<DerivedRole> derivedRoles = new HashSet<>(0);
    @Getter
    @Setter
    @OneToMany
    private Set<SiteUserSecondaryUserRole> siteUserSecondaryUserRoles = new HashSet<>(0);

    public SecondaryUserRole() {
    }

    public SecondaryUserRole(Long secondaryUserRoleId) {
        this.id = secondaryUserRoleId;
    }

    public interface Client {
        String getName();

        Set<DerivedRole> getDerivedRoles();

        Set<SiteUserSecondaryUserRole> getSiteUserSecondaryUserRoles();
    }

}
