package com.video.management.application.handler;

import com.video.management.service.dto.response.ErrorResponse;
import com.video.management.service.exception.DomainExceptionHandler;
import com.video.management.service.exception.VideoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class VideoNotFoundExceptionHandler implements DomainExceptionHandler<VideoNotFoundException> {
    @Override
    @ResponseBody
    @ExceptionHandler(value = {VideoNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleException(VideoNotFoundException exception) {
        return ErrorResponse.create(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }
}
