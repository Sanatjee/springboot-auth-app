package com.sanat.auth_app.exceptions;

import com.sanat.auth_app.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //Resource Not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException exception
    ){
        HttpStatus STATUS = HttpStatus.NOT_FOUND;
        ErrorResponse response = new ErrorResponse(exception.getMessage(),STATUS,"Resource Not Found");
        return ResponseEntity.status(STATUS).body(response);
    }
}
