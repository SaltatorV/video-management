package com.video.management;

import com.video.management.service.dto.command.AddToFavoriteCommand;
import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.dto.response.VideoExistsResponse;

public class FeignClientManager {
    public static VideoExistsResponse videoExists(AddToFavoriteCommand command) {
        return createVideoExistsResponse(command.getTitle());
    }

    public static VideoExistsResponse videoExists(String title) {
        return createVideoExistsResponse(title);
    }

    public static VideoExistsResponse videoNotExists() {
        return createVideoExistsResponse(null);
    }

    private static VideoExistsResponse createVideoExistsResponse(String title) {
        return new VideoExistsResponse(title);
    }

    public static VideoDataResponse createVideoData(String title) {
        return new VideoDataResponse(title,title,title,title,title);
    }
}
