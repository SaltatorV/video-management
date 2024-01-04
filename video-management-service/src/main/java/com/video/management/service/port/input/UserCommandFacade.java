package com.video.management.service.port.input;

import com.video.management.service.dto.command.AddToFavoriteCommand;
import com.video.management.service.dto.response.MessageResponse;

public interface UserCommandFacade {
    MessageResponse addVideoToUserFavorites(String username, AddToFavoriteCommand command);
}
