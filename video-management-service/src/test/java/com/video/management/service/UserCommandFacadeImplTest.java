package com.video.management.service;

import com.video.management.service.dto.command.AddToFavoriteCommand;
import com.video.management.service.exception.UserFavoriteVideoAlreadyExistsException;
import com.video.management.service.port.output.UserCommandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserCommandFacadeImplTest {

    @Mock
    private UserCommandRepository repository;

    @InjectMocks
    private UserCommandFacadeImpl facade;

    @Test
    public void shouldAddVideoToFavorite() {
        //given
        var username = "Username";
        var command = createAddToFavoriteCommand();

        doReturn(false)
                .when(repository)
                .existsBySnapshot(any());

        //when
        var result = facade.addVideoToUserFavorites(username, command);

        //then
        assertEquals("Added video to favorites.", result.getMessage());
    }


    @Test
    public void shouldThrowUserFavoriteVideoAlreadyExistsException() {
        //given
        var username = "Username";
        var command = createAddToFavoriteCommand();

        doReturn(true)
                .when(repository)
                .existsBySnapshot(any());

        //when
        assertThrows(UserFavoriteVideoAlreadyExistsException.class,
                () -> facade.addVideoToUserFavorites(username, command));
    }

    private AddToFavoriteCommand createAddToFavoriteCommand() {
        return new AddToFavoriteCommand("Avatar");
    }
}
