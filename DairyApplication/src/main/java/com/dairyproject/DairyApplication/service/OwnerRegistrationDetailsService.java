package com.dairyproject.DairyApplication.service;

import com.dairyproject.DairyApplication.dto.OwnerRegistrationDetailsDto;
import com.dairyproject.DairyApplication.entity.OwnerRegistrationDetails;

public interface OwnerRegistrationDetailsService {
    OwnerRegistrationDetails createOwnerOfDairy(OwnerRegistrationDetailsDto ownerRegistrationDetailsDto);
    OwnerRegistrationDetails updateOwner(String uniqueId,OwnerRegistrationDetailsDto details);
    String deleteOwner(String id);
    OwnerRegistrationDetails getOwnerDetails(String id);
    boolean checkOwnermobileNumberexist(String mobileNumber);
    boolean checkEmailExist(String email);
}