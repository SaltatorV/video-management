package com.video.management.service.exception;

public class ExternalServiceNotAvailableException extends DomainException{
    public ExternalServiceNotAvailableException() {
        super("Sorry! Video data is temporarily unavailable. Please try again later.");
    }
}
