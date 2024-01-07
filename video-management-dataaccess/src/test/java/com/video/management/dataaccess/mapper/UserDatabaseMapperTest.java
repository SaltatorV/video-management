package com.video.management.dataaccess.mapper;

import com.video.management.dataaccess.entity.UserFavoriteEntity;
import com.video.management.service.dto.UserSnapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDatabaseMapperTest {

    private UserDatabaseMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new UserDatabaseMapper();
    }

    @Test
    public void shouldMapSnapshotToEntity() {
        //given
        var snapshot = createSnapshot();

        //when
        var entity = mapper.mapToEntity(snapshot);

        //then
        assertEquals(snapshot.getUsername(), entity.getUsername());
        assertEquals(snapshot.getVideoTitle(), entity.getVideoTitle());
    }

    @Test
    public void shouldMapEntityToSnapshot() {
        //given
        var entity = createEntity();

        //when
        var snapshot = mapper.mapToSnapshot(entity);

        //then
        assertEquals(entity.getUsername(), snapshot.getUsername());
        assertEquals(entity.getVideoTitle(), snapshot.getVideoTitle());
    }

    private UserSnapshot createSnapshot() {
        return UserSnapshot.create("test", "Avatar");
    }

    private UserFavoriteEntity createEntity() {
        return UserFavoriteEntity.builder()
                .username("test")
                .videoTitle("Avatar")
                .build();
    }
}
