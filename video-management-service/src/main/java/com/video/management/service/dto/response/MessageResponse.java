package com.video.management.service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Schema(
    name = "Message",
    description = "Response to a user with a simple message."

)
public class MessageResponse {
    @Schema(
            description = "Response message content.", example = "Successfully added the video to favorites."
    )
    private final String message;
}
