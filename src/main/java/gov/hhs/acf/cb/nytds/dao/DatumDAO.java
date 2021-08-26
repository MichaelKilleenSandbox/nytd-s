package gov.hhs.acf.cb.nytds.dao;

import gov.hhs.acf.cb.nytds.persistence.entity.Datum;

import java.util.List;


/**
 * Datum access
 */
public interface DatumDAO
{
	List<Datum> getDataForRecord(final Long transmissionRecordId);
}
