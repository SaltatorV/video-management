package com.video.management.application.handler;

import com.video.management.service.dto.response.ErrorResponse;
import com.video.management.service.exception.DomainExceptionHandler;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ConstraintViolationExceptionHandler implements DomainExceptionHandler<ConstraintViolationException> {

    @Override
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse handleException(ConstraintViolationException exception) {
        String message = convertViolations(exception);

        return ErrorResponse.create(HttpStatus.BAD_REQUEST.value(), message);
    }

    private String convertViolations(ConstraintViolationException exception) {
        return exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("/"));
    }
}