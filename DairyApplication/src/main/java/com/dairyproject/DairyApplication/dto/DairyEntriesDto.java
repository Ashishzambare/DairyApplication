package com.dairyproject.DairyApplication.dto;

import com.dairyproject.DairyApplication.entity.FarmerAdvances;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DairyEntriesDto {
    private Long id;
    private FarmerAdvances user;
    private LocalDate createdDate;
    private double cowMilk;
    private double buffaloMilk;
    private double totalPayment;
    private String paymentStatus;
}
