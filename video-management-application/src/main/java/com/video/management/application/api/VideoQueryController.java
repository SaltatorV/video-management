package com.video.management.application.api;

import com.video.management.service.port.input.VideoQueryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideoQueryController {

    private final VideoQueryFacade facade;
    @GetMapping("{title}")
    public Object fetchVideo(@PathVariable String title) {
        return facade.findVideo(title);
    }
}
