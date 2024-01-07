package com.video.management.dataaccess.repository;

import com.video.management.dataaccess.entity.UserFavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserFavoriteEntity, Long> {
    boolean existsByUsernameAndVideoTitle(String username, String videoTitle);

    @Query("SELECT u.videoTitle from UserFavoriteEntity u WHERE u.username = :username")
    List<String> findByUsername(String username);
}
