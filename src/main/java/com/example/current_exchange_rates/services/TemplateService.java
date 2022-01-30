package com.example.current_exchange_rates.services;

import com.example.current_exchange_rates.payload.dto.CourseDtoExchangeRate;
import com.example.current_exchange_rates.payload.dto.CourseDtoFreeCurrency;

public interface TemplateService {

    CourseDtoExchangeRate getInfoWithExchangeRateApi(String currency, String key);

    CourseDtoFreeCurrency getInfoWithFreeCurrencyApi(String currency);


}
