package com.video.management.service.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoExistsResponse {
    @JsonProperty("Title")
    private String title;

    public boolean exists() {
        return title != null;
    }
}
