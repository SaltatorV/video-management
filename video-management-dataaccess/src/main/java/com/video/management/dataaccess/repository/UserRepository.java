package com.video.management.dataaccess.repository;

import com.video.management.dataaccess.entity.UserFavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserFavoriteEntity, Long> {
    boolean existsByUsernameAndVideoTitle(String username, String videoTitle);
}
