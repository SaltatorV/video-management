package com.video.management.application.api;

import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.port.input.UserQueryFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "REST API for User QUERies ",
        description = "The purpose of this REST API is to serve QUERies for the users in the system."
)
@RestController
@RequestMapping(path = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class UserQueryController {

    private final UserQueryFacade facade;

    @Operation(
            summary = "GET user favorites REST API",
            description = "This API endpoint fetches user favorites videos."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "HTTP Status SERVICE_UNAVAILABLE"
            )
    })
    @GetMapping("{username}/favorites")
    public List<VideoDataResponse> fetchUserFavoriteVideos(
            @Parameter(description = "The name of the user for whom the favorite video is added.", required = true)
            @PathVariable String username) {

        return facade.findUserFavorites(username);
    }
}
