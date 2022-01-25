package com.example.current_exchange_rates.utils;

import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CheckUtils {

    public static CodeCurrency checkCode(String code) {
        if (code.equals(CodeCurrency.USD.getCode())) {
            return CodeCurrency.EUR;
        }
        return CodeCurrency.USD;
    }

}
