package io.test_group.my_app_test.rest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler2 {

    // Handler for resource not found (404) exceptions
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), "The requested resource was not found");
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    // A generic exception handler, for other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "An error occurred processing your request");
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Inner class to structure error response
    @Setter
    @Getter
    public static class ApiError {
        // Getters and setters for status, message, and details
        private HttpStatus status;
        private String message;
        private String details;

        public ApiError(HttpStatus status, String message, String details) {
            super();
            this.status = status;
            this.message = message;
            this.details = details;
        }

    }
}
