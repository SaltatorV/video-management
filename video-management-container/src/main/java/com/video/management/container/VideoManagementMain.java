package com.video.management.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.video.management"})
@SpringBootApplication(scanBasePackages = {"com.video.management"})

public class VideoManagementMain {
    public static void main(String[] args) {
        SpringApplication.run(VideoManagementMain.class, args);
    }
}
