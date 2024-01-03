package com.video.management.application.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserQueryControllerTest {
    private UserQueryController userQueryController;

    @BeforeEach
    public void setup() {
        userQueryController = new UserQueryController();
    }

    @Test
    public void shouldFetch1FavoriteMovie() {
        //given
        var username = "username";

        //when
        var result = userQueryController.fetchUserFavoriteMovies(username);

        //then
        assertEquals(1, result.size());
    }

}
