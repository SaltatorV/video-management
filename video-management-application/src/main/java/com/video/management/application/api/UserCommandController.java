package com.video.management.application.api;

import com.video.management.service.dto.command.AddToFavoriteCommand;
import com.video.management.service.dto.response.MessageResponse;
import com.video.management.service.port.input.UserCommandFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "REST API for User COMMANDS",
        description = "The purpose of this REST API is to serve COMMANDs for the users in the system."
)
@RestController
@RequestMapping(path = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class UserCommandController {

    private final UserCommandFacade facade;


    @Operation(
        summary = "ADD video to favorites REST API",
        description = "This API endpoint adds the specific video to user favorites."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status BAD_REQUEST"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "HTTP Status CONFLICT"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status NOT_FOUND"
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "HTTP Status SERVICE_UNAVAILABLE"
            )
    })
    @PutMapping("{username}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse addVideoToFavorites(
            @Parameter(description = "The name of the user for whom the favorite video is added.", required = true)
            @Size(max = 50, message = "Username cannot exceed 50 characters.")
            @PathVariable String username,
            @RequestBody AddToFavoriteCommand command) {
        return facade.addVideoToUserFavorites(username, command);
    }
}
