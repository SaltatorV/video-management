package com.video.management.service.port.input;

import java.util.List;

public interface UserQueryFacade {
    List<Object> findUserFavorites(String username);
}
