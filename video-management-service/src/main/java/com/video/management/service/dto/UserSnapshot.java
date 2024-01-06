package com.video.management.service.dto;

import lombok.Getter;

@Getter
public class UserSnapshot {
    private final String username;
    private final String videoTitle;

    private UserSnapshot(String username, String videoTitle) {
        this.username = username;
        this.videoTitle = videoTitle;
    }

    public static UserSnapshot create(String username, String videoTitle) {
        return new UserSnapshot(username, videoTitle);
    }

}
