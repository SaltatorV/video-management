package com.video.management.dataaccess.adapter;

import com.video.management.dataaccess.repository.UserRepository;
import com.video.management.service.dto.UserSnapshot;
import com.video.management.service.port.output.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository {
    private final UserRepository repository;
    @Override
    public List<String> findUserFavoriteVideos(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public boolean existsBySnapshot(UserSnapshot snapshot) {
        return repository.existsByUsernameAndVideoTitle(snapshot.getUsername(), snapshot.getVideoTitle());
    }
}
