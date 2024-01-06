package com.video.management.service.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Video",
        description = "Schema to hold video information."

)
public class VideoDataResponse {

    @Schema(
            description = "Video title", example = "Avatar: The Way of Water"
    )
    @JsonProperty("Title")
    private String title;
    @Schema(
            description = "Video plot", example = "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora."
    )
    @JsonProperty("Plot")
    private String plot;
    @Schema(
            description = "Video genre", example = "Action, Adventure, Fantasy"
    )
    @JsonProperty("Genre")
    private String genre;
    @Schema(
            description = "Video director", example = "James Cameron"
    )
    @JsonProperty("Director")
    private String director;
    @Schema(
            description = "Video poster", example = "scheme://host:port/images/{size}/{poster_name}"
    )
    @JsonProperty("Poster")
    private String posterUrl;
}
