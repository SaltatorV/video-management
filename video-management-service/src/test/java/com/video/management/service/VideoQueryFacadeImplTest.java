package com.video.management.service;

import com.video.management.service.client.OmdbFeignClient;
import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.dto.response.VideoExistsResponse;
import com.video.management.service.exception.VideoNotExistsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class VideoQueryFacadeImplTest {

    @Mock
    private OmdbFeignClient feignClient;
    @InjectMocks
    private VideoQueryFacadeImpl facade;

    @Test
    public void shouldReturnVideoData() {
        //given
        var title = "Avatar";

        doReturn(createVideoExistResponse(title))
                .when(feignClient)
                .isVideoExists(title);

        doReturn(createVideoDataResponse(title))
                .when(feignClient)
                .fetchVideo(title);

        //when
        var result = facade.findVideo(title);

        //then
        assertEquals(title, result.getTitle());
    }

    @Test
    public void shouldThrowVideoNotExistsException() {
        //given
        var title = "Avatar";

        doReturn(createEmptyVideoResponse())
                .when(feignClient)
                .isVideoExists(title);

        //when
        assertThrows(VideoNotExistsException.class, () -> facade.findVideo(title));

    }

    private VideoExistsResponse createEmptyVideoResponse() {
        return new VideoExistsResponse(null);
    }

    private VideoExistsResponse createVideoExistResponse(String title) {
        return new VideoExistsResponse(title);
    }

    private VideoDataResponse createVideoDataResponse(String title) {
        return new VideoDataResponse(title, title, title, title, title);
    }
}
