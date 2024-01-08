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

import static com.video.management.FeignClientManager.videoExists;
import static com.video.management.FeignClientManager.videoNotExists;
import static com.video.management.ResponseManager.*;
import static com.video.management.URLManager.ADD_TO_FAV_URL;
import static org.mockito.Mockito.doReturn;

@SpringBootTest(classes = VideoManagementMain.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserCommandControllerIntegrationTest {

    @MockBean
    private OmdbFeignClient feignClient;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void shouldReturn201WhenAddVideoToFavorites() throws Exception {
        //given
        var command = addAvatarCommand();

        doReturn(videoExists(command))
                .when(feignClient)
                .isVideoExists(command.getTitle());

        //when
        var result = performAddToFavoritesRequest(validUsername(), command);

        //then
        isStatus201(result);
    }

    @Test
    public void shouldReturn400ForTooLongUsername() throws Exception {
        //given
        var command = addAvatarCommand();

        //when
        var result = performAddToFavoritesRequest(tooLongUsername(), command);

        //then
        isStatus400(result);
    }

    @Test
    public void shouldReturn400ForTooLongTitle() throws Exception {
        var command = addTooLongCommand();

        //when
        var result = performAddToFavoritesRequest(validUsername(), command);

        //then
        isStatus400(result);
    }

    @Test
    public void shouldReturn400ForEmptyTitle() throws Exception {
        var command = addEmptyCommand();

        //when
        var result = performAddToFavoritesRequest(validUsername(), command);

        //then
        isStatus400(result);
    }

    @Test
    public void shouldReturn404WhenNotFoundTitle() throws Exception {
        //given
        var command = addAvatarCommand();

        doReturn(videoNotExists())
                .when(feignClient)
                .isVideoExists(command.getTitle());

        //when
        var result = performAddToFavoritesRequest(validUsername(), command);

        //then
        isStatus404(result);
    }

    @Test
    public void shouldReturn409WhenAddTwoSameVideoForSameUser() throws Exception {
        //given
        var command = addAvatarCommand();

        doReturn(videoExists(command))
                .when(feignClient)
                .isVideoExists(command.getTitle());

        performAddToFavoritesRequest(validUsername(), command);

        //when
        var result = performAddToFavoritesRequest(validUsername(), command);

        //then
        isStatus409(result);
    }

    private AddToFavoriteCommand addAvatarCommand() {
        return createCommand("Avatar");
    }

    private AddToFavoriteCommand addTooLongCommand() {
        return createCommand("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
    }

    private AddToFavoriteCommand addEmptyCommand() {
        return createCommand("");
    }

    private AddToFavoriteCommand createCommand(String title) {
        return new AddToFavoriteCommand(title);
    }

    private String validUsername() {
        return "Test";
    }
    private String tooLongUsername() {
        return "user12345678901234567890123456789012345678901234567890";
    }

    private MvcResult performAddToFavoritesRequest(String username, AddToFavoriteCommand command) throws Exception {
        return mockMvc
                .perform(MockMvcRequestBuilders.put(String.format(ADD_TO_FAV_URL, username))
                        .content(mapper.writeValueAsString(command))
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
}
