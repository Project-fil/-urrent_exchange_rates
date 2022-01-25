package com.example.current_exchange_rates.exceptions;

public class EntityExistException extends RuntimeException {

    public EntityExistException(String message) {
        super(message);
    }

    public EntityExistException() {}

}
