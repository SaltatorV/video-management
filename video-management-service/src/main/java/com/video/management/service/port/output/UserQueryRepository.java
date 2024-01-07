package com.video.management.service.port.output;


import com.video.management.service.dto.UserSnapshot;

import java.util.List;

public interface UserQueryRepository {
    List<String> findUserFavoriteVideos(String username);

    boolean existsBySnapshot(UserSnapshot snapshot);
}
