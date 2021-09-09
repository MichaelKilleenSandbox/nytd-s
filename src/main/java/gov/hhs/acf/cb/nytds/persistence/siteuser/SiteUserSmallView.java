package gov.hhs.acf.cb.nytds.persistence.siteuser;

import org.springframework.beans.factory.annotation.Value;

public interface SiteUserSmallView {
    Long getId();
    String getUserName();
    String getFirstName();
    String getLastName();
    Boolean getLocked();
    @Value("#{target.primaryUserRole.name}")
    String getPrimaryRole();
}
