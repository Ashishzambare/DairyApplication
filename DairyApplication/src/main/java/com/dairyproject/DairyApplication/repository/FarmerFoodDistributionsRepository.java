package com.dairyproject.DairyApplication.repository;

import com.dairyproject.DairyApplication.entity.FarmerFoodDistributions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerFoodDistributionsRepository extends JpaRepository<FarmerFoodDistributions,Long> {
}