package com.video.management.application.api;

import com.video.management.service.port.input.VideoQueryFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "REST API for Video QUERies ",
        description = "The purpose of this REST API is to serve QUERies for the videos in the system."
)
@RestController
@RequestMapping("/videos")
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
            )
    })
    @GetMapping("{title}")
    public Object fetchVideo(
            @Parameter(description = "Name of the video whose data is to be fetched.", required = true)
            @PathVariable String title) {
        return facade.findVideo(title);
    }
}
