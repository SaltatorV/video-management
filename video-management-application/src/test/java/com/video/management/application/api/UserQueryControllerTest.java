package com.video.management.application.api;

import com.video.management.service.port.input.UserQueryFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserQueryControllerTest {

    @Mock
    private UserQueryFacade facade;

    @InjectMocks
    private UserQueryController userQueryController;

    @Test
    public void shouldFetch1FavoriteMovie() {
        //given
        var username = "username";
        var expected = createListWithOneVideo();
        doReturn(expected)
                .when(facade)
                .findUserFavorites(username);

        //when
        var result = userQueryController.fetchUserFavoriteVideos(username);

        //then
        assertEquals(expected, result);
    }

    private List<Object> createListWithOneVideo(){
        return List.of("Video-1");
    }

}
