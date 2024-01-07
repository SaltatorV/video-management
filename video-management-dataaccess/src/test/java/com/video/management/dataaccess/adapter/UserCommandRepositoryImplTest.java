package com.video.management.dataaccess.adapter;

import com.video.management.dataaccess.entity.UserFavoriteEntity;
import com.video.management.dataaccess.mapper.UserDatabaseMapper;
import com.video.management.dataaccess.repository.UserRepository;
import com.video.management.service.dto.UserSnapshot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserCommandRepositoryImplTest {

    @Mock
    private UserDatabaseMapper mapper;
    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserCommandRepositoryImpl commandRepository;

    @Test
    public void shouldSaveSnapshot() {
        //given
        var snapshot = createSnapshot();
        var entity = createEntity(snapshot);
        doReturn(entity)
                .when(mapper)
                .mapToEntity(snapshot);

        //when
        commandRepository.addToFavorite(snapshot);

        //then
        verify(repository, times(1)).save(entity);
    }

    private UserSnapshot createSnapshot() {
        return UserSnapshot.create("test", "Avatar");
    }
    private UserFavoriteEntity createEntity(UserSnapshot snapshot) {
        return UserFavoriteEntity.builder()
                .username(snapshot.getUsername())
                .videoTitle(snapshot.getVideoTitle())
                .build();
    }
}
