package com.video.management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.video.management.container.VideoManagementMain;
import com.video.management.service.client.OmdbFeignClient;
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

import static com.video.management.FeignClientManager.*;
import static com.video.management.ResponseManager.*;
import static com.video.management.URLManager.FETCH_VIDEO_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@SpringBootTest(classes = VideoManagementMain.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class VideoQueryControllerIntegrationTest {
    @MockBean
    private OmdbFeignClient feignClient;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void shouldReturn200AndAvatarVideo() throws Exception {
        //given
        var title = "Avatar";

        doReturn(videoExists(title))
                .when(feignClient)
                .isVideoExists(title);

        doReturn(createVideoData(title))
                .when(feignClient)
                .fetchVideo(title);

        //when
        var result = performFetchVideo(title);

        //then
        isStatus200(result);
        isResultContainTitle(result, title);
    }

    @Test
    public void shouldReturn400ForTooLongTitle() throws Exception {
        //given
        var title = tooLongTitle();

        //when
        var result = performFetchVideo(title);

        //then
        isStatus400(result);
    }

    @Test
    public void shouldReturn404ForNotFoundTitle() throws Exception {
        //given
        var title = "Avatar";

        doReturn(videoNotExists())
                .when(feignClient)
                .isVideoExists(title);

        //when
        var result = performFetchVideo(title);

        //then
        isStatus404(result);
    }


    private MvcResult performFetchVideo(String title) throws Exception {
        return mockMvc
                .perform(MockMvcRequestBuilders.get(String.format(FETCH_VIDEO_URL, title))
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    private void isResultContainTitle(MvcResult result, String title) throws UnsupportedEncodingException {
        assertTrue(result.getResponse().getContentAsString().contains(title));
    }

    private String tooLongTitle() {
        return "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
    }
}
