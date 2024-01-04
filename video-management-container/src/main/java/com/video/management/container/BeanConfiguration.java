package com.video.management.container;

import com.video.management.service.dto.response.MessageResponse;
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
                return new MessageResponse("Success");
            }
        };
    }

    @Bean
    UserQueryFacade userQueryFacade() {
        return new UserQueryFacade() {
            @Override
            public List<Object> findUserFavorites(String username) {
                return List.of("Video-1", "Video-2");
            }
        };
    }

    @Bean
    VideoQueryFacade videoQueryFacade() {
        return new VideoQueryFacade() {
            @Override
            public Object findVideo(String title) {
                return "Video-1";
            }
        };
    }
}