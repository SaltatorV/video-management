package com.video.management.application.handler;

import com.video.management.service.dto.response.ErrorResponse;
import com.video.management.service.exception.DomainExceptionHandler;
import com.video.management.service.exception.UserFavoriteVideoAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class UserFavoriteVideoAlreadyExistsExceptionHandler implements DomainExceptionHandler<UserFavoriteVideoAlreadyExistsException> {
    @Override
    @ResponseBody
    @ExceptionHandler(value = {UserFavoriteVideoAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleException(UserFavoriteVideoAlreadyExistsException exception) {
        return ErrorResponse.create(HttpStatus.CONFLICT.value(), exception.getMessage());
    }
}
