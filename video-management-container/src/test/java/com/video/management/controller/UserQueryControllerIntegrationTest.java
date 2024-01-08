package com.video.management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.video.management.container.VideoManagementMain;
import com.video.management.service.client.OmdbFeignClient;
import com.video.management.service.dto.command.AddToFavoriteCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static com.video.management.FeignClientManager.createVideoData;
import static com.video.management.FeignClientManager.videoExists;
import static com.video.management.ResponseManager.*;
import static com.video.management.URLManager.ADD_TO_FAV_URL;
import static com.video.management.URLManager.FETCH_FAV_VIDEOS_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@SpringBootTest(classes = VideoManagementMain.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserQueryControllerIntegrationTest {



    @MockBean
    private OmdbFeignClient feignClient;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void shouldReturn200AndAvatarAsFavoriteVideo() throws Exception {
        //given
        var title = "Avatar";
        addVideoAsFavorite(validUsername(), title);

        doReturn(createVideoData(title))
                .when(feignClient)
                .fetchVideo(title);

        //when
        var result = performFetchUserFavoriteVideos(validUsername());

        //then
        isStatus200(result);
        isResultContainTitle(result, title);
    }

    @Test
    public void shouldReturn200AndEmptyList() throws Exception {
        //when
        var result = performFetchUserFavoriteVideos(validUsername());

        //then
        isStatus200(result);
        isResultEmpty(result);
    }

    @Test
    public void shouldReturn400ForTooLongUsername() throws Exception {
        //when
        var result = performFetchUserFavoriteVideos(tooLongUsername());

        //then
        isStatus400(result);
    }

    private String validUsername() {
        return "Test";
    }
    private String tooLongUsername() {
        return "user12345678901234567890123456789012345678901234567890";
    }


    private MvcResult performFetchUserFavoriteVideos(String username) throws Exception {
        System.out.println(String.format(FETCH_FAV_VIDEOS_URL, username));
        return mockMvc
                .perform(MockMvcRequestBuilders.get(String.format(FETCH_FAV_VIDEOS_URL, username))
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    private void addVideoAsFavorite(String username, String title) throws Exception {
        var command = new AddToFavoriteCommand(title);

        doReturn(videoExists(command))
                .when(feignClient)
                .isVideoExists(command.getTitle());

        mockMvc
                .perform(MockMvcRequestBuilders.put(String.format(ADD_TO_FAV_URL, username))
                        .content(mapper.writeValueAsString(command))
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    private void isResultContainTitle(MvcResult result, String title) throws UnsupportedEncodingException {
        assertTrue(result.getResponse().getContentAsString().contains(title));
    }

    private void isResultEmpty(MvcResult result) throws UnsupportedEncodingException {
        assertEquals("[]", result.getResponse().getContentAsString());
    }
}
