package com.dairyproject.DairyApplication.service;

import com.dairyproject.DairyApplication.dto.FarmerFoodDistributionsDto;
import com.dairyproject.DairyApplication.entity.FarmerFoodDistributions;

public interface FarmerFoodDistributionsIface {
    FarmerFoodDistributions createFarmerFoodDistribution(FarmerFoodDistributionsDto farmerFoodDistributionsDto);
}