package gov.hhs.acf.cb.nytds.web.api;

import gov.hhs.acf.cb.nytds.persistence.entity.SiteUser;
import gov.hhs.acf.cb.nytds.persistence.siteuser.SiteUserDALService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SiteUserResource {
    private SiteUserDALService siteUserDALService;


    public SiteUserResource(SiteUserDALService siteUserDALService) {
        this.siteUserDALService = siteUserDALService;
    }

    @GetMapping("/siteuser")
    ResponseEntity<List<SiteUser>> getAllSiteUsers() {
        List<SiteUser> siteUserList = siteUserDALService.findAllByStateId(22L);
        return ResponseEntity.ok(siteUserList);
    }
}
