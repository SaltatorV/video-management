package com.video.management.application.handler;

import com.video.management.service.exception.VideoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoNotFoundExceptionHandlerTest {

    private final static int NOT_FOUND_CODE = 404;
    private VideoNotFoundExceptionHandler handler;
    @BeforeEach
    public void setup() {
        handler = new VideoNotFoundExceptionHandler();
    }

    @Test
    public void shouldHandleExternalServiceNotAvailableException() {
        //given
        var exception = createException();

        //when
        var result = handler.handleException(exception);

        //then
        assertEquals(exception.getMessage(), result.getMessage());
        assertEquals(NOT_FOUND_CODE, result.getCode());
    }

    private VideoNotFoundException createException() {
        return new VideoNotFoundException();
    }

}
