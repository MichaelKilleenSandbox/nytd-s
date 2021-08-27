package gov.hhs.acf.cb.nytds.persistence.frequency;

import gov.hhs.acf.cb.nytds.persistence.entity.helper.Frequency;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
class FrequencyDALServiceImpl implements FrequencyDALService {
    @Override
    public List<Frequency> getFrequencies(Collection<String> states, Collection<String> reportPeriods,
                                          Collection<String> elements, Boolean byState, Boolean byReportPeriod, Boolean byElement) {

        throw new NotImplementedException();
    }
}
