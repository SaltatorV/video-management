package com.video.management.application.api;

import com.video.management.service.dto.command.AddToFavoriteCommand;
import com.video.management.service.dto.response.MessageResponse;
import com.video.management.service.port.input.UserCommandFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserCommandControllerTest {

    @Mock
    private UserCommandFacade facade;

    @InjectMocks
    private UserCommandController userCommandController;

    @Test
    public void shouldAddVideoToFavorites() {
        //given
        var username = "username";
        var command = createAddToFavoriteCommand();
        var expected = createSuccessfullMessageResponse();

        doReturn(expected)
                .when(facade)
                .addVideoToUserFavorites(username, command);

        //when
        var result = userCommandController.addVideoToFavorites(username, command);

        //then
        assertEquals(expected, result);
    }

    private MessageResponse createSuccessfullMessageResponse() {
        return MessageResponse.create("Success");
    }

    private AddToFavoriteCommand createAddToFavoriteCommand() {
        return new AddToFavoriteCommand("Avatar: The Way of Water");
    }

}
