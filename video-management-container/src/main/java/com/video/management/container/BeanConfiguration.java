package com.video.management.container;

import com.video.management.service.dto.UserSnapshot;
import com.video.management.service.dto.command.AddToFavoriteCommand;
import com.video.management.service.dto.response.MessageResponse;
import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.port.input.UserCommandFacade;
import com.video.management.service.port.input.UserQueryFacade;
import com.video.management.service.port.input.VideoQueryFacade;
import com.video.management.service.port.output.UserCommandRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class BeanConfiguration {

    @Bean
    UserCommandRepository userCommandRepository() {
        Set<UserSnapshot> snapshots = new HashSet<>();
        return new UserCommandRepository() {
            @Override
            public void addToFavorite(UserSnapshot snapshot) {
                System.out.println("Add video to fav: " + snapshot.getUsername() + " - " + snapshot.getVideoTitle());
                snapshots.add(snapshot);
            }

            @Override
            public boolean existsBySnapshot(UserSnapshot snapshot) {
                System.out.println(snapshots.contains(snapshot));
                return snapshots
                        .stream()
                        .anyMatch(x-> x.getUsername().equals(snapshot.getUsername())
                                && x.getVideoTitle().equals(snapshot.getVideoTitle()));
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
