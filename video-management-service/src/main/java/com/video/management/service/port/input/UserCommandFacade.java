package com.video.management.service.port.input;

import com.video.management.service.dto.response.MessageResponse;

public interface UserCommandFacade {
    MessageResponse addMovieToUserFavorites(String username, String title);
}