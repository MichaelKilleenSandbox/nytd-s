package gov.hhs.acf.cb.nytds.dao.impl;

import gov.hhs.acf.cb.nytds.dao.RecordForFileComparisonWithinReportPeriodDAO;
import gov.hhs.acf.cb.nytds.persistence.entity.helper.RecordForFileComparisonWithinReportPeriod;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Transactional
public class RecordForFileComparisonWithinReportPeriodDAOImpl extends HibernateDaoSupport implements
		RecordForFileComparisonWithinReportPeriodDAO
{
	protected final Logger log = Logger.getLogger(getClass());


	/**
	 * @see RecordForFileComparisonWithinReportPeriodDAO#getRecordsForFileComparisonWithinReportPeriod(Long, Long)
	 * @author Adam Russell (18816)
	 */

	@Override
	public List<RecordForFileComparisonWithinReportPeriod> getRecordsForFileComparisonWithinReportPeriod(
			Long transmission1Id, Long transmission2Id)
	{
		assert (transmission1Id != null && transmission2Id != null);
		Session dbSession = getSessionFactory().getCurrentSession();
		EntityManager em = dbSession.getEntityManagerFactory().createEntityManager();
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("spCrossFileCompWithinReportPd");

		q.setParameter(2, transmission1Id);
		q.setParameter(3, transmission2Id);

		List<RecordForFileComparisonWithinReportPeriod> queryResult = q.getResultList();
		return queryResult;

	}

}
