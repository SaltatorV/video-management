package com.video.management.service.exception;

public abstract class VideoManagementDomainException extends RuntimeException {
    public VideoManagementDomainException(String message) {
        super(message);
    }
}
