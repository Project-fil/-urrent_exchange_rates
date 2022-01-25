package com.example.current_exchange_rates.controllers;

import com.example.current_exchange_rates.entity.CourseEntity;
import com.example.current_exchange_rates.payload.dto.CourseDto;
import com.example.current_exchange_rates.services.CourseService;
import com.example.current_exchange_rates.services.TemplateService;
import com.example.current_exchange_rates.utils.CheckUtils;
import com.example.current_exchange_rates.utils.TransferObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/")
public class RestControllerAppImpl implements RestControllerApp {

    @Value("${app.api.key}")
    private String apiKey;

    private final CourseService courseService;

    private final TemplateService templateService;

    @Override
    public ResponseEntity<Object> getInfoActualCourse(String currency) {
        CourseDto courseDto = this.templateService.getInfoAnotherService(currency, apiKey);
        return ResponseEntity.ok(TransferObject.fromCourse(this.courseService.create(new CourseEntity(
                apiKey,
                courseDto.getLastUpdateCourse(),
                courseDto.getBase_code(),
                CheckUtils.checkCode(currency),
                BigDecimal.valueOf(courseDto.getConversionRates().getUSD()),
                BigDecimal.valueOf(courseDto.getConversionRates().getEUR())
        ))));
    }
}
