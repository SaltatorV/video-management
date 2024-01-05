package com.video.management.service;

import com.video.management.service.port.output.UserQueryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserQueryFacadeImplTest {

    @Mock
    private UserQueryRepository repository;

    @InjectMocks
    private UserQueryFacadeImpl facade;

    @Test
    public void shouldReturnFavoriteVideos() {
        //given
        var username = "Test";
        var titles = createTwoVideoTitles();

        doReturn(titles)
                .when(repository)
                .findUserFavoriteVideos(username);

        //when
        var result = facade.findUserFavorites(username);

        //then
        assertEquals(2, result.size());
    }


    private List<String> createTwoVideoTitles() {
        return List.of("Title-1", "Title-2");
    }

}
