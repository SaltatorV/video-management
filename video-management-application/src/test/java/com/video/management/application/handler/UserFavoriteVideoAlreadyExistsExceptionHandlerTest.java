package com.video.management.application.handler;

import com.video.management.service.exception.UserFavoriteVideoAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserFavoriteVideoAlreadyExistsExceptionHandlerTest {

    private final static int CONFLICT_CODE = 409;
    private UserFavoriteVideoAlreadyExistsExceptionHandler handler;
    @BeforeEach
    public void setup() {
        handler = new UserFavoriteVideoAlreadyExistsExceptionHandler();
    }

    @Test
    public void shouldHandleUserFavoriteVideoAlreadyExistsException() {
        //given
        var exception = createException();

        //when
        var result = handler.handleException(exception);

        //then
        assertEquals(exception.getMessage(), result.getMessage());
        assertEquals(CONFLICT_CODE, result.getCode());
    }

    private UserFavoriteVideoAlreadyExistsException createException() {
        return new UserFavoriteVideoAlreadyExistsException();
    }

}
