package com.video.management.dataaccess.adapter;

import com.video.management.dataaccess.repository.UserRepository;
import com.video.management.service.dto.UserSnapshot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserQueryRepositoryImplTest {
    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserQueryRepositoryImpl queryRepository;

    @Test
    public void shouldReturn3titles() {
        //given
        var expected = List.of("Title-1","Title-2","Title-3");
        var username = "Test";

        doReturn(expected)
                .when(repository)
                .findByUsername(username);

        //when
        var result = queryRepository.findUserFavoriteVideos(username);

        //then
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnTrueForExistsBySnapshot() {
        //given
        var snapshot = createSnapshot();
        doReturn(true)
                .when(repository)
                .existsByUsernameAndVideoTitle(snapshot.getUsername(), snapshot.getVideoTitle());

        //when
        var result = queryRepository.existsBySnapshot(snapshot);

        //then
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseForExistsBySnapshot() {
        //given
        var snapshot = createSnapshot();
        doReturn(false)
                .when(repository)
                .existsByUsernameAndVideoTitle(snapshot.getUsername(), snapshot.getVideoTitle());

        //when
        var result = queryRepository.existsBySnapshot(snapshot);

        //then
        assertFalse(result);
    }

    private UserSnapshot createSnapshot() {
        return UserSnapshot.create("test", "Avatar");
    }
}
