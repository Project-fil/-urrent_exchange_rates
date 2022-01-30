package com.example.current_exchange_rates.controllers;

import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import com.example.current_exchange_rates.payload.responses.ActualCourseResponse;
import com.example.current_exchange_rates.payload.responses.BestCourseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RestControllerApp {

    @GetMapping("exchange/rate/actual/course/get")
    ResponseEntity<ActualCourseResponse> getInfoActualCourseWithExchangeRateApi(@RequestParam(defaultValue = "USD") String currency);

    @GetMapping("free/currency/actual/course/get")
    ResponseEntity<ActualCourseResponse> getInfoActualCourseWithFreeCurrencyApi(@RequestParam(defaultValue = "USD") String currency);

    @GetMapping("best/actual/course/get")
    ResponseEntity<BestCourseResponse> getBestCourseWithOtherService(@RequestParam(defaultValue = "USD") String currency);

    @GetMapping("course/id/get")
    ResponseEntity<ActualCourseResponse> getCourseById(@RequestParam(name = "id") String id);

    @GetMapping("actual/code/get")
    ResponseEntity<CodeCurrency[]> getInfoActualCode();

    @GetMapping("get/all/sort")
    ResponseEntity<List<ActualCourseResponse>> getAllBySort(
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "lastModifiedDate") String sort
    );

}
