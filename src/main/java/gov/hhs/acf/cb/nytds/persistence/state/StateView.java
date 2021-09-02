package gov.hhs.acf.cb.nytds.persistence.state;


import org.springframework.beans.factory.annotation.Value;

public interface StateView {
    Long getId();
    @Value("#{target.region.region}")
    String getRegion();
    String getStateName();
    String getAbbreviation();
    String getFipsCode();
}

