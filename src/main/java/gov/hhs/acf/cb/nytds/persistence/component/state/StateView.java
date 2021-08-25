package gov.hhs.acf.cb.nytds.persistence.component.state;


import gov.hhs.acf.cb.nytds.persistence.component.entity.Region;

public interface StateView {
    Region getRegion();
    String getStateName();
    String getAbbreviation();
    String getFipsCode();
}

