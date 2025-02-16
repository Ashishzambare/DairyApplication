package com.dairyproject.DairyApplication.service.impl;

import com.dairyproject.DairyApplication.Apputil.ApiResponse;
import com.dairyproject.DairyApplication.dto.FarmerFoodDistributionsDto;
import com.dairyproject.DairyApplication.dto.FoodStockDetailsDto;
import com.dairyproject.DairyApplication.entity.FarmerFoodDistributions;
import com.dairyproject.DairyApplication.entity.FoodStockDetails;
import com.dairyproject.DairyApplication.repository.FoodStockDetailsRepository;
import com.dairyproject.DairyApplication.service.FarmerFoodDistributionsIface;
import com.dairyproject.DairyApplication.service.FoodStockDetailsIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodStockDetailsIfaceImpl  implements FoodStockDetailsIface {
    @Autowired
    private FoodStockDetailsRepository foodStockDetailsRepository;
    @Override
    public ApiResponse createFoodStockDetails(FoodStockDetailsDto foodStockDetailsDto) {
        try{
            if(foodStockDetailsDto != null){
                FoodStockDetails foodStockDetail = FoodStockDetails.builder().foodId(113L).stockQuantityKg(foodStockDetailsDto.getStockQuantityKg()).foodName(foodStockDetailsDto.getFoodName()).amountPaid(foodStockDetailsDto.getAmountPaid())
                        .brand(foodStockDetailsDto.getBrand()).buyRate(foodStockDetailsDto.getBuyRate())
                        .saleRate(foodStockDetailsDto.getSaleRate()).unitPrice(foodStockDetailsDto.getBuyRate()/ foodStockDetailsDto.getStockQuantityKg()).quantity(foodStockDetailsDto.getQuantity())
                        .build();
                foodStockDetailsRepository.save(foodStockDetail);
                return new ApiResponse("Food stocks details added succesfully",true,foodStockDetail);
            }
            return new ApiResponse("Food Stock Details not added ",false,null);
        }catch(Exception e){
            e.printStackTrace();
            return new ApiResponse("Something went wrong, please try again",false,null);
        }

    }
}