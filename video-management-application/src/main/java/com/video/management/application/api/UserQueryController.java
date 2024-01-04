package com.video.management.application.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserQueryController {

    @GetMapping("{username}/favorites")
    public List<Object> fetchUserFavoriteMovies(@PathVariable String username) {
        return List.of("Movie-1");
    }
}
