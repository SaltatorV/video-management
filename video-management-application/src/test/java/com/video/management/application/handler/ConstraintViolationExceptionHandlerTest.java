package com.video.management.application.handler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstraintViolationExceptionHandlerTest {
    private final static int BAD_REQUEST = 400;
    private ConstraintViolationExceptionHandler handler;
    @BeforeEach
    public void setup() {
        handler = new ConstraintViolationExceptionHandler();
    }

    @Test
    public void shouldHandleConstraintViolationException() {
        //given
        var exception = createConstraintViolationException();

        //when
        var result = handler.handleException(exception);

        //then
        assertEquals(exception.getMessage(), result.getMessage());
        assertEquals(BAD_REQUEST, result.getCode());
    }

    private ConstraintViolationException createConstraintViolationException() {
        Set<ConstraintViolation<?>> violations = new HashSet<>();
        return new ConstraintViolationException(violations);
    }

}
