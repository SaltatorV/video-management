package com.video.management.service;

import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.port.input.UserQueryFacade;
import com.video.management.service.port.output.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class UserQueryFacadeImpl implements UserQueryFacade {
    private final UserQueryRepository repository;


    @Override
    public List<VideoDataResponse> findUserFavorites(String username) {
        List<String> favoriteVideos = repository.findUserFavoriteVideos(username);
        return mapStringToResponse(favoriteVideos);
    }

    private List<VideoDataResponse> mapStringToResponse(List<String> videos) {
        return videos
                .stream()
                .map(title -> VideoDataResponse.create(title, title, title, title, title))
                .collect(Collectors.toList());
    }
}
