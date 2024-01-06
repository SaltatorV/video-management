package com.video.management.service.client;

import com.video.management.service.dto.response.VideoDataResponse;
import com.video.management.service.dto.response.VideoExistsResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "omdb-api", url = "${omdb.api.url}")
public interface OmdbFeignClient {
    @GetMapping
    @Headers("Content-Type: application/json")
    VideoDataResponse fetchVideo(@RequestParam("t")String title);

    @GetMapping
    @Headers("Content-Type: application/json")
    VideoExistsResponse isVideoExists(@RequestParam("t")String title);
}
