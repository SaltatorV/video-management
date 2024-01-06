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
                snapshots.add(snapshot);
            }

            @Override
            public boolean existsBySnapshot(UserSnapshot snapshot) {
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
}
