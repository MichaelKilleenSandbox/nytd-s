package gov.hhs.acf.cb.nytds.dao;

import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;

import java.util.List;

public interface SiteUserDAO
{
	void deleteAll();

	/**
	 * Returns list of SiteUser with federal user roles in a given email.
	 * @param email email
	 * @return List<SiteUser>
	 */
	List<SiteUser> getFederalUserListByEmail(String email);

	/**
	 * Returns list of all SiteUser in a given email.
	 * @param email email
	 * @return List<SiteUser>
	 */
	List<SiteUser> getAllUserListByEmail(String email);

	List<SiteUser> findAllByRegion(Long regionId);

	List<SiteUser> findAllByStateId(Long stateId);

	List<SiteUser> findAllByPrimaryRole(Long role);

	List<SiteUser> findByStateAndPrimaryRole(Long stateId, Long role);
}


