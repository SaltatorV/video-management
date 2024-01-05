package com.video.management.service.exception;

abstract class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
