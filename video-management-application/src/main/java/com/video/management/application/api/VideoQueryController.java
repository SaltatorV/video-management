package com.video.management.application.api;

import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.port.input.VideoQueryFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "REST API for Video QUERies ",
        description = "The purpose of this REST API is to serve QUERies for the videos in the system."
)
@RestController
@RequestMapping(path = "/videos", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class VideoQueryController {

    private final VideoQueryFacade facade;
    @Operation(
            summary = "GET video data REST API",
            description = "This API endpoint fetch video data."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
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
    @GetMapping("{title}")
    public VideoDataResponse fetchVideo(
            @Parameter(description = "Name of the video whose data is to be fetched.", required = true)
            @Size(max = 255, message = "Video title cannot exceed 50 characters.")
            @PathVariable String title) {
        return facade.findVideo(title);
    }
}
