package com.example.current_exchange_rates.services.impl;

import com.example.current_exchange_rates.payload.dto.CourseDtoExchangeRate;
import com.example.current_exchange_rates.payload.dto.CourseDtoFreeCurrency;
import com.example.current_exchange_rates.services.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    @Value("${app.api.free-currency.url-key}")
    private String freeCurrencyUrl;

    @Value("${app.api.exchange-rate.url}")
    private String exchangeRateApiUrl;

    @Value("${app.api.exchange-rate.actual-option}")
    private String exchangeRateApiActualOption;

    private final RestTemplate restTemplate;

    public CourseDtoExchangeRate getInfoWithExchangeRateApi(String currency, String key) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return this.restTemplate.exchange(
                this.exchangeRateApiUrl + key + this.exchangeRateApiActualOption + currency,
                HttpMethod.GET,
                entity,
                CourseDtoExchangeRate.class
        ).getBody();
    }

    @Override
    public CourseDtoFreeCurrency getInfoWithFreeCurrencyApi(String currency) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return this.restTemplate.exchange(
                this.freeCurrencyUrl + currency,
                HttpMethod.GET,
                entity,
                CourseDtoFreeCurrency.class
        ).getBody();
    }

}
