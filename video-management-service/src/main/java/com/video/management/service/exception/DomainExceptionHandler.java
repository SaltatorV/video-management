package com.video.management.service.exception;

import com.video.management.service.dto.response.ErrorResponse;

public interface DomainExceptionHandler<T> {
    ErrorResponse handleException(T exception);
}
