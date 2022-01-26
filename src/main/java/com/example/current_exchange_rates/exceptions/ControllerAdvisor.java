package com.example.current_exchange_rates.exceptions;

import com.example.current_exchange_rates.payload.responses.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(
                        HttpStatus.NOT_FOUND.ordinal(),
                        e.getMessage(),
                        new Date()
                ));
    }

    @ExceptionHandler(value = EntityExistException.class)
    public ResponseEntity<ErrorResponse> handleEntityExistException(EntityExistException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(
                HttpStatus.BAD_REQUEST.ordinal(),
                e.getMessage(),
                new Date()
        ));
    }

    @ExceptionHandler(value = ServiceUnavailableException.class)
    public ResponseEntity<ErrorResponse> handleAnotherServerException(ServiceUnavailableException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ErrorResponse(
                HttpStatus.SERVICE_UNAVAILABLE.ordinal(),
                e.getMessage(),
                new Date()
        ));
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(
                HttpStatus.BAD_REQUEST.ordinal(),
                e.getMessage(),
                new Date()
        ));
    }

}
