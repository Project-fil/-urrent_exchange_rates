package com.example.current_exchange_rates.entity.enums;

public enum CodeCurrency {

    USD("USD"),
    EUR("EUR");

    private final String code;

    CodeCurrency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
