package com.video.management.service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(
        name = "Video",
        description = "Schema to hold video information."

)
public class VideoDataResponse {

    @Schema(
            description = "Video title", example = "Avatar: The Way of Water"
    )
    private final String title;
    @Schema(
            description = "Video plot", example = "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora."
    )
    private final String plot;
    @Schema(
            description = "Video genre", example = "Action, Adventure, Fantasy"
    )
    private final String genre;
    @Schema(
            description = "Video director", example = "James Cameron"
    )
    private final String director;
    @Schema(
            description = "Video poster", example = "scheme://host:port/images/{size}/{poster_name}"
    )
    private final String posterUrl;

    private VideoDataResponse(String title, String plot, String genre, String director, String posterUrl) {
        this.title = title;
        this.plot = plot;
        this.genre = genre;
        this.director = director;
        this.posterUrl = posterUrl;
    }

    public static VideoDataResponse create(String title, String plot, String genre, String director, String posterUrl) {
        return new VideoDataResponse(title, plot, genre, director, posterUrl);
    }
}
