package gov.hhs.acf.cb.nytds.persistence.component.state;

import gov.hhs.acf.cb.nytds.persistence.component.BaseComponent;
import gov.hhs.acf.cb.nytds.persistence.component.entity.Region;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;

@Getter
public class StateBusinessObject {
    private String regionCode;
    private String stateName;
    private String abbreviation;
    private String fipsCode;

    public StateBusinessObject(Region region, String stateName, String abbreviation, String fipsCode) {
        this.regionCode = region.getRegionCode();
        this.stateName = stateName;
        this.abbreviation = abbreviation;
        this.fipsCode = fipsCode;
    }
}
