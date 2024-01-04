package com.video.management.application.api;

import com.video.management.service.dto.response.MessageResponse;
import com.video.management.service.port.input.UserCommandFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserCommandController {

    private final UserCommandFacade facade;

    @PostMapping("{username}")
    public MessageResponse addVideoToFavorites(@PathVariable String username, @RequestBody String title) {
        return facade.addVideoToUserFavorites(username, title);
    }
}
