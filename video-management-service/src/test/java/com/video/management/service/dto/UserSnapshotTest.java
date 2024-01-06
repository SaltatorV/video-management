package com.video.management.service.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserSnapshotTest {

    @Test
    public void shouldCreateUserSnapshot() {
        //given
        var username = "Username";
        var title = "Video-Title";

        //when
        var result = UserSnapshot.create(username, title);

        //then
        assertEquals(username, result.getUsername());
        assertEquals(title, result.getVideoTitle());
    }
}
