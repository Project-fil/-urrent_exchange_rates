package com.example.current_exchange_rates.controllers;

import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import com.example.current_exchange_rates.payload.responses.ActualCourseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RestControllerApp {

    @GetMapping("actual/course/get")
    ResponseEntity<ActualCourseResponse> getInfoActualCourse(@RequestParam(defaultValue = "USD") String currency);

    @GetMapping("actual/code/get")
    ResponseEntity<CodeCurrency[]> getInfoActualCode();

    @GetMapping("get/all/sort")
    ResponseEntity<List<ActualCourseResponse>> getAllBySort(
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "lastModifiedDate") String sort
    );

}
