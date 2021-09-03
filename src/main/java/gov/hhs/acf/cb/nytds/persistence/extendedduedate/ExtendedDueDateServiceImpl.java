package gov.hhs.acf.cb.nytds.persistence.extendedduedate;

import gov.hhs.acf.cb.nytds.persistence.entity.ExtendedDueDate;
import gov.hhs.acf.cb.nytds.persistence.entity.VwExtendedDueDate;
import gov.hhs.acf.cb.nytds.persistence.reportingperiod.ReportingPeriodDALService;
import gov.hhs.acf.cb.nytds.persistence.state.StateDALService;
import gov.hhs.acf.cb.nytds.persistence.state.StateView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implements ExtendedDueDateService.
 * 
 * @see ExtendedDueDateService
 */
@Transactional
@Service
public class ExtendedDueDateServiceImpl implements ExtendedDueDateService {

    private ExtendedDueDateRepository extendedDueDateRepository;
    private StateDALService stateDALService;
    private ReportingPeriodDALService reportingPeriodDALService;

    public ExtendedDueDateServiceImpl(ExtendedDueDateRepository extendedDueDateRepository, StateDALService stateDALService, ReportingPeriodDALService reportingPeriodDALService) {
        this.extendedDueDateRepository = extendedDueDateRepository;
        this.stateDALService = stateDALService;
        this.reportingPeriodDALService = reportingPeriodDALService;
    }

    /**
     * @see ExtendedDueDateService#getExtendedDueDateData(ExtendedDueDateSearch)
     */
    @Override
    public List<VwExtendedDueDate> getExtendedDueDateData(ExtendedDueDateSearch search) {
        return extendedDueDateRepository.findExtendedDueDateData(search);
    }

    /**
     * @see ExtendedDueDateService#getExtendedDueDateByDueDateID(Long, Long)
     * @return
     */
    @Override
    public Optional<VwExtendedDueDate> getExtendedDueDateByDueDateID(Long dueDateID, Long extendedDueDateId) {
        final var extendedDueDate= extendedDueDateRepository.findExtendedDueDateByDueDateID(dueDateID, extendedDueDateId);
        return extendedDueDate;
    }

    @Override
    public String saveExtendedDueDate(List<ExtendedDueDate> extendedDueDate) {
        final var extendedDueDates = extendedDueDateRepository.saveAll(extendedDueDate);
        return "SUCCESS";
    }

    @Override
    public String deleteExtendedDueDateData(ExtendedDueDate extendedDueDate) {
        extendedDueDateRepository.delete(extendedDueDate);
        return "SUCCESS";
    }


    /**
     * @see ExtendedDueDateService#getReportPeriodNameById(Long)
     * @return
     */
    @Override
    public Optional<String> getReportPeriodNameById(Long reportingPeriodId) {
        return reportingPeriodDALService.findReportPeriodName(reportingPeriodId);
    }
    
    /**
     * @see ExtendedDueDateService#getStateNameById(Long)
     * @return
     */
    @Override
    public Optional<Object> getStateNameById(Long stateId) {
        final var state = stateDALService.findStateById(stateId);
        if(state.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(state.get().getStateName());
        }
    }
    
    /**
     * @see ExtendedDueDateService#getAllStateIds()
     */
    @Override
    public List<Long> getAllStateIds() {
        List<Long> stateIdList = new ArrayList<>();
        List<StateView> allStateArray = stateDALService.findAllStates(0,100).getContent();
        allStateArray.forEach(stateView -> stateIdList.add(stateView.getId()));
        return stateIdList;
    }

}
