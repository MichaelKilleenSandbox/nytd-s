package gov.hhs.acf.cb.nytds.persistence.duedate;

import gov.hhs.acf.cb.nytds.persistence.entity.DueDate;
import gov.hhs.acf.cb.nytds.persistence.entity.ReportingPeriod;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class DueDateDALServiceImpl implements DueDateDALService {
    private DueDateRepository dueDateRepository;

    public DueDateDALServiceImpl(DueDateRepository dueDateRepository) {
        this.dueDateRepository = dueDateRepository;
    }

    @Override
    public Optional<Calendar> findSubmissionDeadline(ReportingPeriod period, Long transmissionTypeId) {
        Optional<DueDate> result = dueDateRepository.findDistinctByReportingPeriod_idAndTransmissionType_id(period.getId(),transmissionTypeId);

        if(result.isPresent()) {
            return Optional.ofNullable(result.get().getSubmissionDate());
        }
        return Optional.empty();
    }
}
