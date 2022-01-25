package com.example.current_exchange_rates.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface RestControllerApp {

    @GetMapping("actual/course/get")
    ResponseEntity<Object> getInfoActualCourse(@RequestParam String currency);

}
