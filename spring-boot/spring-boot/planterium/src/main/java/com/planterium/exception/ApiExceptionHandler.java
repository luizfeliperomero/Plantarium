package com.planterium.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(apiException, HttpStatus.NOT_ACCEPTABLE);
    }
}
