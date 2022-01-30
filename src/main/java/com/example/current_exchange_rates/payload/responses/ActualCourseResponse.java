package com.example.current_exchange_rates.payload.responses;

import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualCourseResponse {

    private String id;

    private String apiKey;

    private String companyName;

    private String lastUpdateCourse;

    private String baseCode;

    private CodeCurrency codeCurrency;

    private BigDecimal usd;

    private BigDecimal eur;

}
