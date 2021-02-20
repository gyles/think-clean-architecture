/*
 * Copyright Stuff Limited
 */

package com.think.clean.web.rest.exception;

import com.think.clean.domain.usecase.exception.DomainException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RequiredArgsConstructor
@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    private final ErrorResponseMapper mapper;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleUncheckedException(RuntimeException exception,
                                                                     HttpServletRequest request) {
        ErrorResponse response = mapper.toErrorResponse(request, INTERNAL_SERVER_ERROR, exception.getMessage());

        return new ResponseEntity<>(response, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleUncheckedException(DomainException exception,
                                                                     HttpServletRequest request) {
        ErrorResponse response = mapper.toErrorResponse(request, UNPROCESSABLE_ENTITY, exception.getMessage());

        return new ResponseEntity<>(response, UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUncheckedException(EntityNotFoundException exception,
                                                                     HttpServletRequest request) {
        ErrorResponse response = mapper.toErrorResponse(request, NOT_FOUND, exception.getMessage());

        return new ResponseEntity<>(response, NOT_FOUND);
    }

}
