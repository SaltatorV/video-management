package com.video.management.service.dto.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorResponseTest {

    @Test
    public void shouldCreateErrorResponse() {
        //given
        var code = 409;
        var message = "Alredy exists";

        //when
        var result = ErrorResponse.create(code, message);

        //then
        assertEquals(code, result.getCode());
        assertEquals(message, result.getMessage());
    }
}
