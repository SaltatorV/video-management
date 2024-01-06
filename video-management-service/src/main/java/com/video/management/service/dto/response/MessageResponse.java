package com.video.management.service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(
    name = "Message",
    description = "Response to a user with a simple message."

)
public class MessageResponse {
    @Schema(
            description = "Response message content.", example = "Sample positive or negative message"
    )
    private final String message;

    MessageResponse(String message) {
        this.message = message;
    }

    public static MessageResponse create(String message) {
        return new MessageResponse(message);
    }
}
