package com.video.management.application.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCommandControllerTest {
    private UserCommandController userCommandController;

    @BeforeEach
    public void setup() {
        userCommandController = new UserCommandController();
    }

    @Test
    public void shouldFetch1FavoriteMovie() {
        //given
        var username = "username";
        var title = "Avatar: The Way of Water";

        //when
        var result = userCommandController.addMovieToFavorites(username, title);

        //then
        assertEquals("success", result);
    }
}
