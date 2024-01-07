package com.video.management.service.port.output;

import com.video.management.service.dto.UserSnapshot;

public interface UserCommandRepository {
    void addToFavorite(UserSnapshot snapshot);
}
