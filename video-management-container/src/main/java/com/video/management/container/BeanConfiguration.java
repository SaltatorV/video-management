package com.video.management.container;

import com.video.management.service.dto.response.MessageResponse;
import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.port.input.UserCommandFacade;
import com.video.management.service.port.input.UserQueryFacade;
import com.video.management.service.port.input.VideoQueryFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean
    UserCommandFacade userCommandFacade() {
        return new UserCommandFacade() {
            @Override
            public MessageResponse addVideoToUserFavorites(String username, String title) {
                return MessageResponse.create("Success");
            }
        };
    }

    @Bean
    UserQueryFacade userQueryFacade() {
        return new UserQueryFacade() {
            @Override
            public List<VideoDataResponse> findUserFavorites(String username) {
                return List.of(createAvatarTheWayOfWaterVideoResponse());
            }
        };
    }

    @Bean
    VideoQueryFacade videoQueryFacade() {
        return new VideoQueryFacade() {
            @Override
            public VideoDataResponse findVideo(String title) {
                return createAvatarTheWayOfWaterVideoResponse();
            }
        };
    }

    private VideoDataResponse createAvatarTheWayOfWaterVideoResponse() {
        return VideoDataResponse.create("Avatar: The Way of Water",
                "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora.",
                "Action, Adventure, Fantasy", "James Cameron",
                "scheme://host:port/images/{size}/{poster_name}");
    }
}
