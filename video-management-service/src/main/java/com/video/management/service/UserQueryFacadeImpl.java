package com.video.management.service;

import com.video.management.service.client.OmdbFeignClient;
import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.port.input.UserQueryFacade;
import com.video.management.service.port.output.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class UserQueryFacadeImpl implements UserQueryFacade {
    private final UserQueryRepository repository;
    private final OmdbFeignClient omdbFeignClient;

    @Override
    public List<VideoDataResponse> findUserFavorites(String username) {
        List<String> favoriteVideos = repository.findUserFavoriteVideos(username);

        return fetchVideoData(favoriteVideos);
    }

    private List<VideoDataResponse> fetchVideoData(List<String> titles) {
        List<VideoDataResponse> response = new ArrayList<>();

        titles
            .forEach(title -> response.add(omdbFeignClient.fetchVideo(title)));

        return response;
    }
}
