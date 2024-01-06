package com.video.management.application.handler;

import com.video.management.service.exception.ExternalServiceNotAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExternalServiceNotAvailableExceptionHandlerTest {

    private final static int SERVICE_UNAVAILABLE_CODE = 503;
    private ExternalServiceNotAvailableExceptionHandler handler;
    @BeforeEach
    public void setup() {
        handler = new ExternalServiceNotAvailableExceptionHandler();
    }

    @Test
    public void shouldHandleExternalServiceNotAvailableException() {
        //given
        var exception = createException();

        //when
        var result = handler.handleException(exception);

        //then
        assertEquals(exception.getMessage(), result.getMessage());
        assertEquals(SERVICE_UNAVAILABLE_CODE, result.getCode());
    }

    private ExternalServiceNotAvailableException createException() {
        return new ExternalServiceNotAvailableException();
    }

}
