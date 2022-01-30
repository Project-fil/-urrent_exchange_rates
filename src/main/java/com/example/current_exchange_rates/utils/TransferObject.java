package com.example.current_exchange_rates.utils;

import com.example.current_exchange_rates.entity.CourseEntity;
import com.example.current_exchange_rates.payload.responses.ActualCourseResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransferObject {

    public static ActualCourseResponse fromCourse(CourseEntity payload) {
        return new ActualCourseResponse(
                payload.getId(),
                payload.getApiKey(),
                payload.getCompanyName(),
                payload.getLastUpdateCourse(),
                payload.getBaseCode(),
                payload.getCodeCurrency(),
                payload.getUsd(),
                payload.getEur()
        );
    }

}
