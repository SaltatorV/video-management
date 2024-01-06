package com.video.management.service.exception;

public class VideoNotFoundException extends DomainException{
    public VideoNotFoundException() {
        super("Not found video with the given name.");
    }
}
