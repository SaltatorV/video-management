package com.video.management.container;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.video.management"})
@SpringBootApplication(scanBasePackages = {"com.video.management"})
@OpenAPIDefinition(
        info = @Info(
                title = "Video management REST API Documentation",
                version = "0.0.1")
        )
public class VideoManagementMain {
    public static void main(String[] args) {
        SpringApplication.run(VideoManagementMain.class, args);
    }
}
