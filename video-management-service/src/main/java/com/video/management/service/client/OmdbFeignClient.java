package com.video.management.service.client;

import com.video.management.service.dto.response.VideoDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdb-api", url = "https://www.omdbapi.com",fallback = OmdbFallback.class)
public interface OmdbFeignClient {
    @GetMapping
    VideoDataResponse fetchVideo(@RequestParam("t")String title, @RequestParam("apikey") String apikey);
}
