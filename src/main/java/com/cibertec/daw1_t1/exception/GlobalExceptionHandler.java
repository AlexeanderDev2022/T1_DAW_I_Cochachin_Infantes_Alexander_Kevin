package com.cibertec.daw1_t1.exception;

import com.cibertec.daw1_t1.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Maneja ResponseStatusException (ej: 404)
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResponseStatusException ex) {
        String statusText = ex.getStatusCode().value() + " " + ex.getStatusCode().toString();

        ErrorResponse error = new ErrorResponse(
                ex.getStatusCode().value(),
                statusText,
                ex.getReason()
        );

        return new ResponseEntity<>(error, ex.getStatusCode());
    }

    // Maneja errores de validación (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        // Tomamos todos los errores de los campos y los concatenamos
        String errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "400 BAD_REQUEST",
                errores
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}