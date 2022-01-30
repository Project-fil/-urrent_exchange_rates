package com.example.current_exchange_rates.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BestCourseResponse {

    private String baseCurrency;

    private String toCurrency;

    private BigDecimal bestCourse;

    private String bestCompany;

    private BigDecimal badCourse;

    private String badCompany;

}
