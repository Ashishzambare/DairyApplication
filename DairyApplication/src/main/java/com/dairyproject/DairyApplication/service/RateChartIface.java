package com.dairyproject.DairyApplication.service;

import com.dairyproject.DairyApplication.Apputil.ApiResponse;
import com.dairyproject.DairyApplication.dto.RateChartDto;
import com.dairyproject.DairyApplication.entity.RateChart;

import java.util.List;

public interface RateChartIface {
    ApiResponse createRateChart(RateChartDto rateChartDto);
    ApiResponse updateRateChart(long id,RateChartDto rateChartDto);
    ApiResponse getRateChart();
}