package com.example.current_exchange_rates.payload.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDtoExchangeRate {

    @JsonProperty("base_code")
    private String base_code;

    @JsonProperty("conversion_rates")
    private ConversionRates conversionRates;
}