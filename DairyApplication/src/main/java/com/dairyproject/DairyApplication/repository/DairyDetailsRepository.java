package com.dairyproject.DairyApplication.repository;

import com.dairyproject.DairyApplication.entity.Collections;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DairyDetailsRepository extends JpaRepository<Collections,Long> {

}
