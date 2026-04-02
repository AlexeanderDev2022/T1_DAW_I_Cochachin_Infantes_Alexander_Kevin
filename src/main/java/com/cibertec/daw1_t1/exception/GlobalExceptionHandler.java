package com.cibertec.daw1_t1.exception;

import com.cibertec.daw1_t1.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResponseStatusException ex) {
        // Construimos el texto del error manualmente
        String statusText = ex.getStatusCode().value() + " " + ex.getStatusCode().toString();

        ErrorResponse error = new ErrorResponse(
                ex.getStatusCode().value(),  // 404, 400, etc.
                statusText,                  // "404 NOT_FOUND"
                ex.getReason()               // mensaje que pusiste
        );

        return new ResponseEntity<>(error, ex.getStatusCode());
    }
}