package com.video.management.application.api;

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
        var title = "Avatar: The Way of Water";
        var expected = createSuccessfullMessageResponse();

        doReturn(expected)
                .when(facade)
                .addVideoToUserFavorites(username, title);

        //when
        var result = userCommandController.addVideoToFavorites(username, title);

        //then
        assertEquals(expected, result);
    }

    private MessageResponse createSuccessfullMessageResponse() {
        return new MessageResponse("Success");
    }
}
