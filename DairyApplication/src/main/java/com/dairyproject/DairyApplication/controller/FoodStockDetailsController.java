package com.dairyproject.DairyApplication.controller;

import com.dairyproject.DairyApplication.Apputil.ApiResponse;
import com.dairyproject.DairyApplication.dto.FoodStockDetailsDto;
import com.dairyproject.DairyApplication.service.FoodStockDetailsIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FoodStockDetailsController {
    @Autowired
    private FoodStockDetailsIface foodStockDetailsIface;

    @PostMapping("/foodstockDetails")
    public ApiResponse addFoodStockDetails(@RequestBody FoodStockDetailsDto foodStockDetailsDto){
        return foodStockDetailsIface.createFoodStockDetails(foodStockDetailsDto);
    }
}