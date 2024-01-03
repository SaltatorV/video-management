package com.video.management.application.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieControllerTest {

    private MovieController movieController;

    @BeforeEach
    public void setup() {
        movieController = new MovieController();
    }

    @Test
    public void shouldFetchSingleMovie() {
        //given
        var title = "Avatar: The Way of Water";

        //when
        var result = movieController.fetchMovie(title);

        //then
        assertEquals(title, result);
    }
}
