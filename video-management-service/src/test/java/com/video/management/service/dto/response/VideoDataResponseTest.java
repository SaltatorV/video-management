package com.video.management.service.dto.response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoDataResponseTest {

    @Test
    public void shouldCreateVideoDataResponse() {
        //given
        var title = "Title";
        var plot = "Plot";
        var genre = "Genre";
        var director = "Director";
        var posterUrl = "Url";

        //when
        var result = VideoDataResponse.create(title, plot, genre, director, posterUrl);

        //then
        assertEquals(title, result.getTitle());
        assertEquals(plot, result.getPlot());
        assertEquals(genre, result.getGenre());
        assertEquals(director, result.getDirector());
        assertEquals(posterUrl, result.getPosterUrl());
    }

}
