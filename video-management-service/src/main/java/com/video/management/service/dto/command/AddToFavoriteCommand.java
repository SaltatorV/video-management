package com.video.management.service.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(
        name = "Add video to favorite command",
        description = "The purpose of this command is to add a specific video to the user favorites."

)
public class AddToFavoriteCommand {
    @Schema(
            description = "Name of the video to be added to favorites.", example = "Avatar: The Way of Water"
    )
    private String title;
}
