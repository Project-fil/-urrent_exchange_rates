package com.example.current_exchange_rates.exceptions;

public class KeyNotValidException extends RuntimeException {

    public KeyNotValidException(String message) {
        super(message);
    }

    public KeyNotValidException() {
    }

}
