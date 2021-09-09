package gov.hhs.acf.cb.nytds.persistence.siteuser;

import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;

import java.util.List;
import java.util.Optional;

public interface SiteUserDALService {
    void deleteAll();

    /**
     * Returns list of SiteUser with federal user roles in a given email.
     * @param email email
     * @return List<SiteUser>
     */
    List<SiteUser> findFederalUserListByEmail(String email);

    /**
     * Returns list of all SiteUser in a given email.
     * @param email email
     * @return List<SiteUser>
     */
    List<SiteUser> findAllUserListByEmail(String email);

    List<SiteUser> findAllByRegion(Long regionId);

    List<SiteUser> findAllByStateId(Long stateId);

    List<SiteUser> findAllByPrimaryRole(Long role);

    List<SiteUser> findByStateAndPrimaryRole(Long stateId, Long role);

    Optional<SiteUserSmallView> findSiteUserByUserName(String userName);
}
