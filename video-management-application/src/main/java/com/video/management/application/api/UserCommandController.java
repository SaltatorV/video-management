package com.video.management.application.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserCommandController {
    @PostMapping("{username}")
    public String addMovieToFavorites(@PathVariable String username, @RequestBody String title) {
        return "success";
    }
}
