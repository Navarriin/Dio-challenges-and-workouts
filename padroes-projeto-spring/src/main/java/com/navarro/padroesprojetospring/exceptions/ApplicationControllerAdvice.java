package com.navarro.padroesprojetospring.exceptions;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    private final HttpStatus notFound = HttpStatus.NOT_FOUND;

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> NotFoundExceptionHandler(Exception exception) {
        return ResponseEntity.status(notFound)
                .body(new ErrorMessage(notFound, exception.getMessage()));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorMessage> feignExceptionHandler(Exception exception) {
        return ResponseEntity.status(notFound)
                .body(new ErrorMessage(notFound, "Cep not found!"));
    }
}
