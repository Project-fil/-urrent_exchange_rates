package com.example.current_exchange_rates.controllers.impl;

import com.example.current_exchange_rates.controllers.RestControllerApp;
import com.example.current_exchange_rates.entity.CourseEntity;
import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import com.example.current_exchange_rates.payload.dto.CourseDto;
import com.example.current_exchange_rates.payload.responses.ActualCourseResponse;
import com.example.current_exchange_rates.services.CourseService;
import com.example.current_exchange_rates.services.TemplateService;
import com.example.current_exchange_rates.utils.CheckUtils;
import com.example.current_exchange_rates.utils.TransferObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.current_exchange_rates.utils.CheckUtils.checkDirection;
import static com.example.current_exchange_rates.utils.CheckUtils.checkSortWord;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/")
public class RestControllerAppImpl implements RestControllerApp {

    @Value("${app.api.key}")
    private String apiKey;

    private final CourseService courseService;

    private final TemplateService templateService;

    @Override
    public ResponseEntity<ActualCourseResponse> getInfoActualCourse(String currency) {
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

    @Override
    public ResponseEntity<CodeCurrency[]> getInfoActualCode() {
        return ResponseEntity.ok(CodeCurrency.values());
    }

    @Override
    public ResponseEntity<List<ActualCourseResponse>> getAllBySort(String direction, String sort) {
        return ResponseEntity.ok(this.courseService.getAllHistory(
                Sort.by(checkDirection(direction), checkSortWord(sort))).stream()
                .map(TransferObject::fromCourse)
                .collect(Collectors.toList())
        );
    }


}
