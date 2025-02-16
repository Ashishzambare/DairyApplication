package com.dairyproject.DairyApplication.service.impl;

import com.dairyproject.DairyApplication.Apputil.ApiResponse;
import com.dairyproject.DairyApplication.Apputil.MilkType;
import com.dairyproject.DairyApplication.Apputil.SessionUtil;
import com.dairyproject.DairyApplication.dto.RateChartDto;
import com.dairyproject.DairyApplication.entity.RateChart;
import com.dairyproject.DairyApplication.repository.RateChartRepository;
import com.dairyproject.DairyApplication.service.RateChartIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RateChartIfaceImpl implements RateChartIface {
    @Autowired
    private RateChartRepository rateChartRepository;

    @Override
    public ApiResponse createRateChart(RateChartDto rateChartDto) {
        RateChart rateChart = RateChart.builder().animalType(String.valueOf(rateChartDto.getAnimalType().equalsIgnoreCase("cow")? MilkType.COW:MilkType.BUFFELLOW)).effectiveDate(LocalDate.now())
                .session(SessionUtil.getCurrentSession()).pricePerLiter(rateChartDto.getPricePerLiter())
                .maxFatPercentage(rateChartDto.getMaxFatPercentage()).minFatPercentage(rateChartDto.getMinFatPercentage())
                .baseFatPercentage(rateChartDto.getBaseFatPercentage()).baseSNFPercentage(rateChartDto.getBaseSNFPercentage())
                .build();
        rateChartRepository.save(rateChart);
        return new ApiResponse("Rate chart created successfully", true, rateChart);
    }

    @Override
    public ApiResponse updateRateChart(long id, RateChartDto rateChartDto) {
        RateChart rateChart = rateChartRepository.findById(id).get();
        if (rateChart != null) {
            rateChart.setAnimalType(rateChartDto.getAnimalType() != null ? rateChartDto.getAnimalType() : rateChart.getAnimalType());
            rateChart.setSession(rateChartDto.getSession() != null ? rateChartDto.getSession() : rateChart.getSession());
            rateChart.setAnimalType(rateChartDto.getAnimalType() != null ? rateChartDto.getAnimalType() : rateChart.getAnimalType());
            rateChart.setEffectiveDate(rateChartDto.getEffectiveDate() != null ? rateChartDto.getEffectiveDate() : rateChart.getEffectiveDate());
            rateChart.setSession(rateChartDto.getSession() != null ? rateChartDto.getSession() : rateChart.getSession());
            rateChart.setMaxFatPercentage(rateChartDto.getMaxFatPercentage() != 0.0 ? rateChartDto.getMaxFatPercentage() : rateChart.getMaxFatPercentage());
            rateChart.setMinFatPercentage(rateChartDto.getMinFatPercentage() != 0.0 ? rateChartDto.getMinFatPercentage() : rateChart.getMinFatPercentage());
            rateChart.setPricePerLiter(rateChartDto.getPricePerLiter() != 0.0 ? rateChartDto.getPricePerLiter() : rateChart.getPricePerLiter());
            rateChart.setBaseFatPercentage(rateChartDto.getBaseFatPercentage()!=0.0?rateChartDto.getBaseFatPercentage():rateChart.getBaseFatPercentage());
            rateChart.setBaseSNFPercentage(rateChartDto.getBaseSNFPercentage()!=0.0?rateChartDto.getBaseSNFPercentage():rateChart.getBaseSNFPercentage());
            rateChartRepository.save(rateChart);
            System.out.println(rateChart.getBaseSNFPercentage());
            return new ApiResponse("Rate chart updated successfully", true, rateChart);
        }
        return new ApiResponse("Rate chart not found", false, null);
    }

    @Override
    public ApiResponse getRateChart() {
        List<RateChart> ratechartAll = rateChartRepository.findAll();
        if (ratechartAll != null) {
            return new ApiResponse("fetched all the ratechart data",true,ratechartAll);
        }
        return null;
    }

}