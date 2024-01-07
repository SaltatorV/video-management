package com.video.management.service.port.input;

import com.video.management.service.dto.command.AddToFavoriteCommand;
import com.video.management.service.dto.response.MessageResponse;
import jakarta.validation.Valid;

public interface UserCommandFacade {
    MessageResponse addVideoToUserFavorites(String username, @Valid AddToFavoriteCommand command);
}
