package com.example.current_exchange_rates.services.impl;

import com.example.current_exchange_rates.payload.dto.CourseDto;
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

    @Value("${app.api.url}")
    private String otherServiceUrl;

    @Value("${app.api.actual}")
    private String actual;

    private final RestTemplate restTemplate;

    @Override
    public CourseDto getInfoAnotherService(String currency, String key) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return this.restTemplate.exchange(
                otherServiceUrl + key + actual + currency,
                HttpMethod.GET,
                entity,
                CourseDto.class
        ).getBody();
    }

}
