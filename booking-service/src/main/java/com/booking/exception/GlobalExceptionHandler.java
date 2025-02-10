package com.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    // handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public Mono<ResponseEntity<ErrorDetails>> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), "ResourceNotFoundException");
        return Mono.just(new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorDetails>> handleGlobalException(Exception exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                "webRequest.getDescription(false)");
        return Mono.just(new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR));
    }
}