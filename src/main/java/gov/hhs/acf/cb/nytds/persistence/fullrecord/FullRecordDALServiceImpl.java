package gov.hhs.acf.cb.nytds.persistence.fullrecord;

import gov.hhs.acf.cb.nytds.persistence.entity.RecordToExport;
import gov.hhs.acf.cb.nytds.persistence.entity.Transmission;
import gov.hhs.acf.cb.nytds.persistence.entity.TransmissionRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class FullRecordDALServiceImpl implements FullRecordDALService {

    private FullRecordRepository fullRecordRepository;
    private ElemementFullRecordRepository elemementRepository;
    private DatumFullRecordRepository datumRepository;

    FullRecordDALServiceImpl(FullRecordRepository fullRecordRepository, ElemementFullRecordRepository elemementRepository, DatumFullRecordRepository datumRepository) {
        this.fullRecordRepository = fullRecordRepository;
        this.elemementRepository = elemementRepository;
        this.datumRepository = datumRepository;
    }

    @Override
    public RecordToExport findFullRecord(TransmissionRecord transmissionRecord) {
        return null;
    }

    @Override
    public List<RecordToExport> findFullRecordsForTransmission(Transmission transmission) {
        return null;
    }

    //    @Override
//    public RecordToExport findFullRecord(TransmissionRecord transmissionRecord)
//    {
//        if (transmissionRecord == null)
//        {
//            return null;
//        }
//
//        List<RecordToExport> fullRecords = fullRecordRepository.findAllTheFullRecordByTransmissionRecord(transmissionRecord.getId());
//        assert(fullRecords.size() == 1);
//        return fullRecords.get(0);
//    }
//
//    /**
//     * @author Adam Russell (18816)
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<RecordToExport> findFullRecordsForTransmission(Transmission transmission)
//    {
//        assert(transmission != null);
//
//
//        ;
//        String query;
//        // get all the NYTD elements
//        List<Element> elements = elemementRepository.findAllElements();
//
//        // Check the entries already in RecordToExport first, as the transmission
//        // may, in fact, be an active submission.
//        List<RecordToExport> fullRecords = fullRecordRepository.findFullRecordByTransmission(transmission.getId());
//
//        // If not already in persisted as RecordToExport objects,
//        // fabricate some objects (not to be persisted!) from all the datum objects
//        // in a transmission
//        if (fullRecords.isEmpty())
//        {
//            List<Datum> data = datumRepository.findAllDatum(transmission.getId());
//
//            for (TransmissionRecord transmissionRecord : transmission.getTransmissionRecords())
//            {
//                RecordToExport fullRecord = new RecordToExport();
//                fullRecord.setId(transmissionRecord.getId());
//                //	fullRecord.setTransmissionRecord(transmissionRecord);
//                //	fullRecord.setTransmission(transmissionRecord.getTransmission());
//                fullRecord.setReportingPeriod(transmissionRecord.getTransmission().getReportingPeriod().getName());
//                fullRecord.setFederalFileId(transmissionRecord.getTransmission().getFederalFileId());
//                fullRecord.setRecordNote(transmissionRecord.getNotes());
//                fullRecord.setOutcomePopulation(null);
//                if (transmissionRecord.getOutcomePopulation() != null)
//                {
//                    fullRecord.setOutcomePopulation(transmissionRecord.getOutcomePopulation().getName());
//                }
//                fullRecord.setServedPopulation(null);
//                if (transmissionRecord.getServedPopulation() != null)
//                {
//                    fullRecord.setServedPopulation(transmissionRecord.getServedPopulation().getName());
//                }
//
//                for (Element element : elements)
//                {
//                    int datumIndex;
//                    String elementName = element.getName();
//                    Datum datum = new Datum();
//                    datum.setTransmissionRecord(transmissionRecord);
//                    datum.setElement(element);
//                    datumIndex = Collections.binarySearch(data, datum, new DataToExportComparator());
//                    datum = data.get(datumIndex);
//
//                    fullRecord.setElementValueAndNote(elementName, datum.getValue(), datum.getNote());
//                }
//
//                fullRecords.add(fullRecord);
//            }
//        }
//
//        return fullRecords;
//    }
}
