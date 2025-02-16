package com.dairyproject.DairyApplication.controller;

import com.dairyproject.DairyApplication.Apputil.ApiResponse;
import com.dairyproject.DairyApplication.dto.FarmersDetailsDto;
import com.dairyproject.DairyApplication.entity.FarmersDetails;
import com.dairyproject.DairyApplication.service.FarmerIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FarmerController {
    @Autowired
    private FarmerIface farmerIface;

    @PostMapping("/register/farmer")
    public ApiResponse registerFarmer(@RequestBody FarmersDetailsDto farmersDetailsDto) {
        return farmerIface.createFarmer(farmersDetailsDto);
    }

    @GetMapping("/getallfarmer")
    public List<FarmersDetails> getAllFarmers() {
        return farmerIface.getAllFarmers();
    }
    @DeleteMapping("/deletefarmer/{uniqueid}")
    public String deleteFarmer(@PathVariable String uniqueid ) {
        return farmerIface.deleteFarmer(uniqueid);

    }
    @GetMapping("/getfarmer/{uniqueId}")
    public ApiResponse getFarmerById(@PathVariable("uniqueId") String uniqueId){
        return  farmerIface.getFarmerById(uniqueId);
    }
    @GetMapping("/get/farmer/list/{type}/{value}")
    public ApiResponse getFarmersListBySearchType(@PathVariable int type,@PathVariable String value){
        return  farmerIface.getFarmersListBySearchType(type,value);
    }
    @GetMapping("/farmers/details")
    public ApiResponse getFarmerDetails(@RequestParam(required = false) String mobile,
                                        @RequestParam(required = false) String name) {
        return farmerIface.getFarmerdetailsByMobileOrName(mobile, name);
    }

}