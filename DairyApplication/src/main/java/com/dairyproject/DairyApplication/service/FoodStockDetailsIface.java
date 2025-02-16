package com.dairyproject.DairyApplication.service;

import com.dairyproject.DairyApplication.Apputil.ApiResponse;
import com.dairyproject.DairyApplication.dto.FoodStockDetailsDto;
import com.dairyproject.DairyApplication.entity.FoodStockDetails;

public interface FoodStockDetailsIface {
    ApiResponse createFoodStockDetails(FoodStockDetailsDto foodStockDetailsDto);
}