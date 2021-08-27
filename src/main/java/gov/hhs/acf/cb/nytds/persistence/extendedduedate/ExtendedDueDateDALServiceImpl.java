package gov.hhs.acf.cb.nytds.persistence.extendedduedate;

import gov.hhs.acf.cb.nytds.persistence.entity.ExtendedDueDate;
import gov.hhs.acf.cb.nytds.persistence.entity.VwExtendedDueDate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ExtendedDueDateDALServiceImpl implements ExtendedDueDateDALService {

    @Override
    public List<VwExtendedDueDate> findExtendedDueDateData(ExtendedDueDateSearch search) {
        return null;
    }

    @Override
    public VwExtendedDueDate findExtendedDueDateByDueDateID(Long dueDateID, Long extendedDueDateId) {
        return null;
    }

    @Override
    public String saveExtendedDueDate(List<ExtendedDueDate> extendedDueDate) {
        return null;
    }

    @Override
    public String deleteExtendedDueDateData(ExtendedDueDate extendedDueDate) {
        return null;
    }
}
