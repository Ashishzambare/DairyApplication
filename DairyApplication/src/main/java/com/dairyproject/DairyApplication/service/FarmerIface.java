package com.dairyproject.DairyApplication.service;

import com.dairyproject.DairyApplication.Apputil.ApiResponse;
import com.dairyproject.DairyApplication.dto.FarmersDetailsDto;
import com.dairyproject.DairyApplication.entity.FarmersDetails;

import java.util.List;

public interface FarmerIface {
    ApiResponse createFarmer(FarmersDetailsDto farmersDetailsDto);
    List<FarmersDetails> getAllFarmers();
    ApiResponse updateFarmer(String farmerUniqueId, FarmersDetailsDto updatedFarmer);

    String deleteFarmer(String uniqueid);
    ApiResponse getFarmerById(String uniqueId);
    ApiResponse getFarmersListBySearchType(int type,String value);
    ApiResponse getFarmerdetailsByMobileOrName(String mobileNumber,String name);
}