package com.video.management.service.client;

import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.exception.ExternalServiceNotAvailableException;

public class OmdbFallback implements OmdbFeignClient{
    @Override
    public VideoDataResponse fetchVideo(String title, String apikey) {
        throw new ExternalServiceNotAvailableException();
    }
}
