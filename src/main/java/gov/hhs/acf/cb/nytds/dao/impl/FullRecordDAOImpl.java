package gov.hhs.acf.cb.nytds.dao.impl;


import gov.hhs.acf.cb.nytds.dao.FullRecordDAO;
import gov.hhs.acf.cb.nytds.persistence.entity.RecordToExport;
import gov.hhs.acf.cb.nytds.persistence.entity.Transmission;
import gov.hhs.acf.cb.nytds.persistence.entity.TransmissionRecord;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class FullRecordDAOImpl extends HibernateDaoSupport implements FullRecordDAO
{

	@Override
	public RecordToExport getFullRecord(TransmissionRecord transmissionRecord) {
		return null;
	}

	@Override
	public List<RecordToExport> getFullRecordsForTransmission(Transmission transmission) {
		return null;
	}
}
