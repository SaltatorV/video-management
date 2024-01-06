package com.video.management.service.client;

import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.dto.response.VideoExistsResponse;
import com.video.management.service.exception.ExternalServiceNotAvailableException;

public class OmdbFallback implements OmdbFeignClient{
    @Override
    public VideoDataResponse fetchVideo(String title) {
        throw new ExternalServiceNotAvailableException();
    }

    @Override
    public VideoExistsResponse isVideoExists(String title) {
        throw new ExternalServiceNotAvailableException();
    }
}
