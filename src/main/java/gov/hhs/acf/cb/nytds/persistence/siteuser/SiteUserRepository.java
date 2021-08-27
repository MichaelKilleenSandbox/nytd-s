package gov.hhs.acf.cb.nytds.persistence.siteuser;

import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser,Long> {
    List<SiteUser> findSiteUsersByEmailAddressAndDeletedAndPrimaryUserRole_IdIn(String emailAddress, Boolean deleted, List<Long> roleId);
    List<SiteUser> findSiteUsersByEmailAddressAndDeletedFalse(String emailAddress);
    List<SiteUser> findSiteUsersByPrimaryUserRole_IdAndRegion_IdAndDeletedFalse(Long userRoleId, Long regionId);
    List<SiteUser> findSiteUsersByPrimaryUserRole_IdAndState_IdAndDeletedFalse(Long userRoleId, Long stateId);
    List<SiteUser> findSiteUsersByPrimaryUserRoleAndDeletedFalse(Long userRoleId);


}
