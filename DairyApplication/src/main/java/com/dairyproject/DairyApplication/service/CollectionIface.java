package com.dairyproject.DairyApplication.service;

import com.dairyproject.DairyApplication.Apputil.ApiResponse;
import com.dairyproject.DairyApplication.dto.CollectionsDto;
import com.dairyproject.DairyApplication.entity.Collections;

public interface CollectionIface {
    ApiResponse createCollection(CollectionsDto collectionsDto);
    ApiResponse getAllCollectionByFarmerUniqueId(String uniqueId);
    ApiResponse updateCollection(Long collectionId,CollectionsDto collectionsDto);
    ApiResponse deleteCollection(Long collectionId);
    ApiResponse getCollectionDateWise(String startDate,String endDate);
    //ApiResponse getCollectionFarmerWise();

}