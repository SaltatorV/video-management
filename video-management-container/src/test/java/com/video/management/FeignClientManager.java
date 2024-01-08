package com.video.management;

import com.video.management.service.dto.command.AddToFavoriteCommand;
import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.dto.response.VideoExistsResponse;

public class FeignClientManager {
    public static VideoExistsResponse videoExists(AddToFavoriteCommand command) {
        return new VideoExistsResponse(command.getTitle());
    }
    public static VideoExistsResponse videoNotExists() {
        return new VideoExistsResponse(null);
    }

    public static VideoDataResponse createVideoData(String title) {
        return new VideoDataResponse(title,title,title,title,title);
    }
}
