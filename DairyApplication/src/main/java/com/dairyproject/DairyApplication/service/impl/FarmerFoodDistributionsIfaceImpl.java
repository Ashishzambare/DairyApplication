package com.dairyproject.DairyApplication.service.impl;

import com.dairyproject.DairyApplication.dto.FarmerFoodDistributionsDto;
import com.dairyproject.DairyApplication.entity.FarmerFoodDistributions;
import com.dairyproject.DairyApplication.entity.FarmersDetails;
import com.dairyproject.DairyApplication.repository.FarmerFoodDistributionsRepository;
import com.dairyproject.DairyApplication.repository.FarmerRepository;
import com.dairyproject.DairyApplication.service.FarmerFoodDistributionsIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerFoodDistributionsIfaceImpl implements FarmerFoodDistributionsIface {
    @Autowired
    private FarmerFoodDistributionsRepository farmerFoodDistributionsRepository;
    @Autowired
    private FarmerRepository farmerRepository;


    @Override
    public FarmerFoodDistributions createFarmerFoodDistribution(FarmerFoodDistributionsDto farmerFoodDistributionsDto) {
        FarmersDetails existUser = farmerRepository.findByFarmerUniqueId(farmerFoodDistributionsDto.getFarmerUniqueid());
        if(existUser!=null){

        }

        return null;
    }
}