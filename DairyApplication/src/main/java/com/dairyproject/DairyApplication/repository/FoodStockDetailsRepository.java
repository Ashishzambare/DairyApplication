package com.dairyproject.DairyApplication.repository;

import com.dairyproject.DairyApplication.entity.FoodStockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodStockDetailsRepository extends JpaRepository<FoodStockDetails,Long> {
}