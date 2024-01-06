package com.video.management.service.client;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OmdbConfiguration {
    @Value("${omdb.api.key}")
    private String apikey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> template.query("apikey", apikey);
    }
}
