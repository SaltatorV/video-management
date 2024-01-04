package com.video.management.service.port.input;

import com.video.management.service.dto.response.VideoDataResponse;

import java.util.List;

public interface UserQueryFacade {
    List<VideoDataResponse> findUserFavorites(String username);
}
