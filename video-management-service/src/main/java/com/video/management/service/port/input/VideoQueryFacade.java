package com.video.management.service.port.input;

import com.video.management.service.dto.response.VideoDataResponse;

public interface VideoQueryFacade {

    VideoDataResponse findVideo(String title);
}
