package com.video.management.dataaccess.mapper;

import com.video.management.dataaccess.entity.UserFavoriteEntity;
import com.video.management.service.dto.UserSnapshot;
import org.springframework.stereotype.Component;

@Component
public class UserDatabaseMapper {

    public UserSnapshot mapToSnapshot(UserFavoriteEntity entity) {
        return UserSnapshot.create(entity.getUsername(), entity.getVideoTitle());
    }

    public UserFavoriteEntity mapToEntity(UserSnapshot snapshot) {
        return UserFavoriteEntity.builder()
                .username(snapshot.getUsername())
                .videoTitle(snapshot.getVideoTitle())
                .build();
    }
}
