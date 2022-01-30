package com.example.current_exchange_rates.utils;

import com.example.current_exchange_rates.exceptions.IllegalArgumentException;
import com.example.current_exchange_rates.payload.dto.CourseDtoExchangeRate;
import com.example.current_exchange_rates.payload.dto.CourseDtoFreeCurrency;
import com.example.current_exchange_rates.payload.responses.BestCourseResponse;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class CheckBestCourse {

    public BestCourseResponse checkBestCourse(CourseDtoFreeCurrency freeCurrency, CourseDtoExchangeRate exchangeRate, String currency, String apiKeyExchangeRate) {
        BestCourseResponse bestCourseResponse;
        switch (currency.toUpperCase()) {
            case ("USD"):
                bestCourseResponse = equalsValueEur(freeCurrency, exchangeRate, apiKeyExchangeRate);
                break;
            case ("EUR"):
                bestCourseResponse = equalsValueUsd(freeCurrency, exchangeRate, apiKeyExchangeRate);
                break;
            default:
                throw new IllegalArgumentException("Code not valid");
        }
        return bestCourseResponse;
    }

    private BestCourseResponse equalsValueEur(CourseDtoFreeCurrency freeCurrency, CourseDtoExchangeRate exchangeRate, String apiKeyExchangeRate) {
        if (freeCurrency.getConversionRates().getEUR() >= exchangeRate.getConversionRates().getEUR()) {
           return new BestCourseResponse(
                    freeCurrency.getQuery().getBaseCurrency(),
                    CheckUtils.checkCode(freeCurrency.getQuery().getBaseCurrency()).getCode(),
                    BigDecimal.valueOf(freeCurrency.getConversionRates().getEUR()),
                    CheckUtils.checkCompany(freeCurrency.getQuery().getApiKey()),
                    BigDecimal.valueOf(exchangeRate.getConversionRates().getEUR()),
                    CheckUtils.checkCompany(apiKeyExchangeRate)
            );
        } else {
            return new BestCourseResponse(
                    exchangeRate.getBase_code(),
                    CheckUtils.checkCode(exchangeRate.getBase_code()).getCode(),
                    BigDecimal.valueOf(exchangeRate.getConversionRates().getEUR()),
                    CheckUtils.checkCompany(apiKeyExchangeRate),
                    BigDecimal.valueOf(freeCurrency.getConversionRates().getEUR()),
                    CheckUtils.checkCompany(freeCurrency.getQuery().getApiKey())
            );
        }
    }

    private BestCourseResponse equalsValueUsd(CourseDtoFreeCurrency freeCurrency, CourseDtoExchangeRate exchangeRate, String apiKeyExchangeRate) {
        if (freeCurrency.getConversionRates().getUSD() >= exchangeRate.getConversionRates().getUSD()) {
            return new BestCourseResponse(
                    freeCurrency.getQuery().getBaseCurrency(),
                    CheckUtils.checkCode(freeCurrency.getQuery().getBaseCurrency()).getCode(),
                    BigDecimal.valueOf(freeCurrency.getConversionRates().getUSD()),
                    CheckUtils.checkCompany(freeCurrency.getQuery().getApiKey()),
                    BigDecimal.valueOf(exchangeRate.getConversionRates().getUSD()),
                    CheckUtils.checkCompany(apiKeyExchangeRate)
            );
        } else {
            return new BestCourseResponse(
                    exchangeRate.getBase_code(),
                    CheckUtils.checkCode(exchangeRate.getBase_code()).getCode(),
                    BigDecimal.valueOf(exchangeRate.getConversionRates().getUSD()),
                    CheckUtils.checkCompany(apiKeyExchangeRate),
                    BigDecimal.valueOf(freeCurrency.getConversionRates().getUSD()),
                    CheckUtils.checkCompany(freeCurrency.getQuery().getApiKey())
            );
        }
    }

}
