package gov.hhs.acf.cb.nytds.persistence.frequency;

import gov.hhs.acf.cb.nytds.persistence.entity.helper.Frequency;

import java.util.Collection;
import java.util.List;

public interface FrequencyDALService {
    List<Frequency> getFrequencies(Collection<String> states, Collection<String> reportPeriods,
                                          Collection<String> elements, Boolean byState, Boolean byReportPeriod, Boolean byElement);
}
