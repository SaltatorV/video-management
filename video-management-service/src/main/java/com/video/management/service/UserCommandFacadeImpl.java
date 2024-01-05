package com.video.management.service;

import com.video.management.service.dto.UserSnapshot;
import com.video.management.service.dto.command.AddToFavoriteCommand;
import com.video.management.service.dto.response.MessageResponse;
import com.video.management.service.exception.UserFavoriteVideoAlreadyExistsException;
import com.video.management.service.port.input.UserCommandFacade;
import com.video.management.service.port.output.UserCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserCommandFacadeImpl implements UserCommandFacade {

    private final UserCommandRepository repository;

    @Override
    public MessageResponse addVideoToUserFavorites(String username, AddToFavoriteCommand command) {
        UserSnapshot snapshot = createUserSnapshot(username, command);

        if(isSnapshotAlreadyExists(snapshot)) {
            throw new UserFavoriteVideoAlreadyExistsException();
        }

        repository.addToFavorite(snapshot);

        return MessageResponse.create("Added video to favorites.");
    }

    private UserSnapshot createUserSnapshot(String username, AddToFavoriteCommand command) {
        return UserSnapshot.create(username, command.getTitle());
    }

    private boolean isSnapshotAlreadyExists(UserSnapshot snapshot) {
        return repository.existsBySnapshot(snapshot);
    }
}
