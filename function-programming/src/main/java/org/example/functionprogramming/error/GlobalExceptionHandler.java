package org.example.functionprogramming.error;


import org.example.functionprogramming.error.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(IllegalArgumentException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                3000,
                exception.getMessage(),
                exception.getCause().toString(),
                Timestamp.from(Instant.now())
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
