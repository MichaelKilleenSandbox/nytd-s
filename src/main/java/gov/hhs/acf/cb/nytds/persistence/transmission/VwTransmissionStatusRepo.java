package gov.hhs.acf.cb.nytds.persistence.transmission;

import gov.hhs.acf.cb.nytds.persistence.entity.helper.VwTransmissionStatus;
import gov.hhs.acf.cb.nytds.util.UserRoleEnum;

import java.util.List;

public interface VwTransmissionStatusRepo {


    List<VwTransmissionStatus> findVwTransmissionStatusByAdminFedRole(UserRoleEnum role);

    List<VwTransmissionStatus> findVwTransmissionStatusByStateRole(String stateName);

    List<VwTransmissionStatus> findVwTransmissionStatusByRegionalRole(String region);

}
