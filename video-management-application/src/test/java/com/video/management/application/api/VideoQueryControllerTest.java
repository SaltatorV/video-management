package com.video.management.application.api;

import com.video.management.service.dto.response.VideoDataResponse;
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
        var expected = createAvatarTheWayOfWaterVideoResponse();
        doReturn(expected)
                .when(facade)
                .findVideo(expected.getTitle());

        //when
        var result = videoQueryController.fetchVideo(expected.getTitle());

        //then
        assertEquals(expected, result);
    }

    private VideoDataResponse createAvatarTheWayOfWaterVideoResponse() {
        return new VideoDataResponse("Avatar: The Way of Water",
                "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora.",
                "Action, Adventure, Fantasy", "James Cameron",
                "scheme://host:port/images/{size}/{poster_name}");
    }
}
