package com.video.management.service;

import com.video.management.service.client.OmdbFeignClient;
import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.exception.VideoNotExistsException;
import com.video.management.service.port.input.VideoQueryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoQueryFacadeImpl implements VideoQueryFacade {
    private final OmdbFeignClient feignClient;
    @Override
    public VideoDataResponse findVideo(String title) {
        if(isVideoNotExists(title)) {
            throw new VideoNotExistsException();
        }

        return feignClient.fetchVideo(title);
    }

    private boolean isVideoNotExists(String title) {
        return !feignClient.isVideoExists(title).exists();
    }
}
