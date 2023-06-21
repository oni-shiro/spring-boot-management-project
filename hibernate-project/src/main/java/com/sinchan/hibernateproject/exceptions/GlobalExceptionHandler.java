package com.sinchan.hibernateproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sinchan.hibernateproject.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Resource not found exception

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e) {
        String message = e.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, "404 Not Found");
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    // Data Integrity Violation Exception

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {

        String message = e.getMessage();
        System.out.println(message);
        ApiResponse apiResponse = new ApiResponse(message, "400 Bad Request");
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> apiException(ApiException e) {
        String message = e.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, "404 Not Found");
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

}
