package gov.hhs.acf.cb.nytds.persistence.siteuser;

import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class SiteUserDALServiceImpl implements SiteUserDALService {

    private SiteUserRepository siteUserRepository;

    public SiteUserDALServiceImpl(SiteUserRepository siteUserRepository) {
        this.siteUserRepository = siteUserRepository;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<SiteUser> findFederalUserListByEmail(String email) {
        List<Long> roleIds = new ArrayList<>();
        roleIds.add(2L);
        roleIds.add(3L);
        List<SiteUser> siteUserList = siteUserRepository.findSiteUsersByEmailAddressAndDeletedAndPrimaryUserRole_IdIn(email,Boolean.FALSE,roleIds);
        return siteUserList;
    }

    @Override
    public List<SiteUser> findAllUserListByEmail(String email) {
        List<SiteUser> siteUserList = siteUserRepository.findSiteUsersByEmailAddressAndDeletedFalse(email);
        return siteUserList;
    }

    @Override
    public List<SiteUser> findAllByRegion(Long regionId) {
        return siteUserRepository.findSiteUsersByPrimaryUserRole_IdAndRegion_IdAndDeletedFalse(3L, regionId);
    }

    @Override
    public List<SiteUser> findAllByStateId(Long stateId) {
        return siteUserRepository.findSiteUsersByPrimaryUserRole_IdAndState_IdAndDeletedFalse(4L, stateId);
    }

    @Override
    public List<SiteUser> findAllByPrimaryRole(Long role) { // TODO mjk 8/27/2021 Make sure this is using the roleID.
        return siteUserRepository.findSiteUsersByPrimaryUserRoleAndDeletedFalse(role);
    }

    @Override
    public List<SiteUser> findByStateAndPrimaryRole(Long stateId, Long role) {
        return siteUserRepository.findSiteUsersByPrimaryUserRole_IdAndState_IdAndDeletedFalse(role, stateId);
    }
}
