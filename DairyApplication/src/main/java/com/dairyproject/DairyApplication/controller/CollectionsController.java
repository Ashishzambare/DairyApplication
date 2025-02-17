package com.dairyproject.DairyApplication.controller;

import com.dairyproject.DairyApplication.Apputil.ApiResponse;
import com.dairyproject.DairyApplication.dto.CollectionsDto;
import com.dairyproject.DairyApplication.service.CollectionIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CollectionsController {
    @Autowired
    private CollectionIface collectionIface;
    @PostMapping("/createCollection")
    public ApiResponse createCollection(@RequestBody CollectionsDto collectionsDto){
        return collectionIface.createCollection(collectionsDto);
    }
    @GetMapping("/getallcollection/{uniqueId}")
    public ApiResponse getAllCollections(@PathVariable String  uniqueId){
        return collectionIface.getAllCollectionByFarmerUniqueId(uniqueId);
    }
    @GetMapping("/getcollection/datewise")
    public ApiResponse getCollectionFromToDate(@RequestParam(required = true) String startDate,@RequestParam(required = true)String endDate){
        return collectionIface.getCollectionDateWise(startDate, endDate);
    }
    @DeleteMapping("/delete/{collectionId}")
    public ApiResponse deleteCollection(@PathVariable Long collectionId){
        return collectionIface.deleteCollection(collectionId);
    }
}