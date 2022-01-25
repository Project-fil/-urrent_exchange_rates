package com.example.current_exchange_rates.services;

import com.example.current_exchange_rates.payload.dto.CourseDto;

public interface TemplateService {

    CourseDto getInfoAnotherService(String currency, String key);

}
