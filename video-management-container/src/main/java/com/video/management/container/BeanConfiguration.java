package com.video.management.container;

import com.video.management.service.dto.UserSnapshot;
import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.port.input.VideoQueryFacade;
import com.video.management.service.port.output.UserCommandRepository;
import com.video.management.service.port.output.UserQueryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class BeanConfiguration {
    Set<UserSnapshot> snapshots = new HashSet<>();
    @Bean
    UserCommandRepository userCommandRepository() {

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
    UserQueryRepository userQueryRepository() {
        return new UserQueryRepository() {
            @Override
            public List<String> findUserFavoriteVideos(String username) {
                return snapshots
                        .stream()
                        .filter(x->x.getUsername().equals(username))
                        .map(UserSnapshot::getVideoTitle)
                        .collect(Collectors.toList());
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
