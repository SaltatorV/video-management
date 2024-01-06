package com.video.management.service.exception;

public class VideoNotExistsException extends DomainException{
    public VideoNotExistsException() {
        super("Video with the given name does not exist.");
    }
}
