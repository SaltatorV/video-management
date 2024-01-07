package com.video.management.dataaccess.adapter;

import com.video.management.dataaccess.mapper.UserDatabaseMapper;
import com.video.management.dataaccess.repository.UserRepository;
import com.video.management.service.dto.UserSnapshot;
import com.video.management.service.port.output.UserCommandRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCommandRepositoryImpl implements UserCommandRepository {

    private final UserRepository repository;
    private final UserDatabaseMapper mapper;

    @Override
    public void addToFavorite(UserSnapshot snapshot) {
        repository.save(mapper.mapToEntity(snapshot));
    }
}
