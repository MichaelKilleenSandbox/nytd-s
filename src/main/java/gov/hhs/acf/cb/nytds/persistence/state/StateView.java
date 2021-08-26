package gov.hhs.acf.cb.nytds.persistence.state;


import gov.hhs.acf.cb.nytds.persistence.entity.Region;

public interface StateView {
    Long getId();
    Region getRegion();
    String getStateName();
    String getAbbreviation();
    String getFipsCode();
}

