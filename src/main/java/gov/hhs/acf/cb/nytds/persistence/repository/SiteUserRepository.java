package gov.hhs.acf.cb.nytds.persistence.repository;

import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {


    //    List<SiteUser> getFederalUserListByEmail(String email);
    List<SiteUser> findAllByEAndEmailAddressAndPrimaryUserRole(String user, Long primaryUserRole);
//
//    /**
//     * Returns list of all SiteUser in a given email.
//     * @param email email
//     * @return List<SiteUser>
//     */
//    List<SiteUser> getAllUserListByEmail(String email);
List<SiteUser> findAllByEAndEmailAddress(String emailAddress);
//
//    List<SiteUser> findAllByRegion(Long regionId);
    List<SiteUser> findAllByRegion(Long regionId);
//
//    List<SiteUser> findAllByStateId(Long stateId);
    List<SiteUser> findAllByState(Long stateId);
//
    List<SiteUser> findAllByPrimaryUserRole(Long role);

    List<SiteUser> findAllByStateAndPrimaryUserRole();
//
//    List<SiteUser> findByStateAndPrimaryRole(Long stateId, Long role);
}