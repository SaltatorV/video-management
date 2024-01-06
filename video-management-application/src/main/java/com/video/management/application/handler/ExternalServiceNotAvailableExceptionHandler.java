package com.video.management.application.handler;

import com.video.management.service.dto.response.ErrorResponse;
import com.video.management.service.exception.DomainExceptionHandler;
import com.video.management.service.exception.ExternalServiceNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExternalServiceNotAvailableExceptionHandler implements DomainExceptionHandler<ExternalServiceNotAvailableException> {
    @Override
    @ResponseBody
    @ExceptionHandler(value = {ExternalServiceNotAvailableException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorResponse handleException(ExternalServiceNotAvailableException exception) {
        return ErrorResponse.create(HttpStatus.SERVICE_UNAVAILABLE.value(), exception.getMessage());
    }
}
