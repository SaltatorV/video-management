package com.video.management.service.exception;

public class UserFavoriteVideoAlreadyExistsException extends DomainException {
    public UserFavoriteVideoAlreadyExistsException() {
        super("The user already has the specified film in their favorites.");
    }
}
