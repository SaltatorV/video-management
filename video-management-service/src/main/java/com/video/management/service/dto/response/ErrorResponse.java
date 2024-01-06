package com.video.management.service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(
        name = "Error",
        description = "Response to a user with a error message."

)
public class ErrorResponse extends MessageResponse{

    @Schema(
            description = "Error code", example = "409"
    )
    private final String code;

    private ErrorResponse(String code, String message) {
        super(message);
        this.code = code;
    }

    public static ErrorResponse create(String code, String message) {
        return new ErrorResponse(code, message);
    };
}
