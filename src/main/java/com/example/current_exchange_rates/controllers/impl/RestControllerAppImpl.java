package com.example.current_exchange_rates.controllers.impl;

import com.example.current_exchange_rates.controllers.RestControllerApp;
import com.example.current_exchange_rates.entity.CourseEntity;
import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import com.example.current_exchange_rates.payload.dto.CourseDtoExchangeRate;
import com.example.current_exchange_rates.payload.dto.CourseDtoFreeCurrency;
import com.example.current_exchange_rates.payload.responses.ActualCourseResponse;
import com.example.current_exchange_rates.payload.responses.BestCourseResponse;
import com.example.current_exchange_rates.services.CourseService;
import com.example.current_exchange_rates.services.TemplateService;
import com.example.current_exchange_rates.utils.CheckBestCourse;
import com.example.current_exchange_rates.utils.CheckUtils;
import com.example.current_exchange_rates.utils.Converter;
import com.example.current_exchange_rates.utils.TransferObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.current_exchange_rates.utils.CheckUtils.checkDirection;
import static com.example.current_exchange_rates.utils.CheckUtils.checkSortWord;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/")
public class RestControllerAppImpl implements RestControllerApp {

    @Value("${app.api.exchange-rate.key}")
    private String apiKey;

    private final CourseService courseService;

    private final TemplateService templateService;

    @Override
    public ResponseEntity<ActualCourseResponse> getInfoActualCourseWithExchangeRateApi(@NotBlank String currency) {
        CourseDtoExchangeRate exchangeRate = this.templateService.getInfoWithExchangeRateApi(currency, apiKey);
        return ResponseEntity.ok(TransferObject.fromCourse(this.courseService.create(new CourseEntity(
                apiKey,
                CheckUtils.checkCompany(apiKey),
                Converter.convertDate(new Date()),
                exchangeRate.getBase_code(),
                CheckUtils.checkCode(currency),
                BigDecimal.valueOf(exchangeRate.getConversionRates().getUSD()),
                BigDecimal.valueOf(exchangeRate.getConversionRates().getEUR())
        ))));
    }

    @Override
    public ResponseEntity<ActualCourseResponse> getInfoActualCourseWithFreeCurrencyApi(@NotBlank String currency) {
        CourseDtoFreeCurrency freeCurrency = this.templateService.getInfoWithFreeCurrencyApi(currency);
        return ResponseEntity.ok(TransferObject.fromCourse(this.courseService.create(new CourseEntity(
                freeCurrency.getQuery().getApiKey(),
                CheckUtils.checkCompany(freeCurrency.getQuery().getApiKey()),
                Converter.convertDate(new Date()),
                freeCurrency.getQuery().getBaseCurrency(),
                CheckUtils.checkCode(currency),
                BigDecimal.valueOf(freeCurrency.getConversionRates().getUSD()),
                BigDecimal.valueOf(freeCurrency.getConversionRates().getEUR())
        ))));
    }

    @Override
    public ResponseEntity<BestCourseResponse> getBestCourseWithOtherService(String currency) {
        return ResponseEntity.ok(CheckBestCourse.checkBestCourse(
                this.templateService.getInfoWithFreeCurrencyApi(currency),
                this.templateService.getInfoWithExchangeRateApi(currency, apiKey),
                currency,
                apiKey
                ));
    }

    @Override
    public ResponseEntity<ActualCourseResponse> getCourseById(@NotBlank String id) {
        return ResponseEntity.ok(TransferObject.fromCourse(this.courseService.getById(UUID.fromString(id))));
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
