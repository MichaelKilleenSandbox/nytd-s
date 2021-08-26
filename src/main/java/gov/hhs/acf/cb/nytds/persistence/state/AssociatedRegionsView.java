package gov.hhs.acf.cb.nytds.persistence.state;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface AssociatedRegionsView {
    @Value("#{target.region.states}")
    List<StateView> getStates();
}
