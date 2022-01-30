package com.example.current_exchange_rates.mocks;

import com.example.current_exchange_rates.entity.CourseEntity;
import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class CourseEntityMock {

    public static CourseEntity defaultCourseEur = new CourseEntity(
            "defaultIdUer",
            "6933516f73f2016658690a3a",
            "ExchangeRate-API",
            "Wed, 26 Jan 2022 00:00:02 +0000",
            "EUR",
            CodeCurrency.USD,
            BigDecimal.valueOf(1.131100),
            BigDecimal.valueOf(1.000000),
            null,
            null
    );

    public static CourseEntity defaultCourseUsd = new CourseEntity(
            "defaultIdUsd",
            "6933516f73f2016658690a3a",
            "ExchangeRate-API",
            "Wed, 26 Jan 2022 00:00:04 +0000",
            "USD",
            CodeCurrency.EUR,
            BigDecimal.valueOf(1.000000),
            BigDecimal.valueOf(0.858500),
            null,
            null
    );

}
