package com.video.management.service.port.output;


import java.util.List;

public interface UserQueryRepository {
    List<String> findUserFavoriteVideos(String username);
}
