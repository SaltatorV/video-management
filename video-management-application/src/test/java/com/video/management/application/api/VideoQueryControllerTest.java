package com.video.management.application.api;

import com.video.management.service.port.input.VideoQueryFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class VideoQueryControllerTest {

    @Mock
    private VideoQueryFacade facade;

    @InjectMocks
    private VideoQueryController videoQueryController;

    @Test
    public void shouldFetchSingleVideo() {
        //given
        var expected = "Avatar: The Way of Water";
        doReturn(expected)
                .when(facade)
                .findVideo(expected);

        //when
        var result = videoQueryController.fetchVideo(expected);

        //then
        assertEquals(expected, result);
    }
}
