package com.video.management.service.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Add To Favorite COMMAND",
        description = "The purpose of this command is to add a specific video to the user favorites."

)
public class AddToFavoriteCommand {
    @Schema(
            description = "Name of the video to be added to favorites.", example = "Avatar: The Way of Water"
    )
    @NotEmpty(message = "Title may not be empty.")
    @Size(max = 255, message = "Title cannot exceed 255 characters.")
    private String title;
}
