package com.video.management.application.api;

import com.video.management.service.port.input.UserQueryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserQueryController {

    private final UserQueryFacade facade;

    @GetMapping("{username}/favorites")
    public List<Object> fetchUserFavoriteVideos(@PathVariable String username) {
        return facade.findUserFavorites(username);
    }
}
