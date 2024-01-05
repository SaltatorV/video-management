package com.video.management.service.dto.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageResponseTest {

    @Test
    public void shouldCreateMessageResponse() {
        //given
        var expected = "Success";

        //when
        var result = MessageResponse.create(expected);

        //then
        assertEquals(expected, result.getMessage());
    }
}
