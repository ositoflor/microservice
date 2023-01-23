package com.api.microservice.microservice.services;

import com.api.microservice.microservice.domain.Login;
import com.api.microservice.microservice.services.dto.TokenDto;

public interface UserService {
    TokenDto loginUser(Login login);
    boolean validateToken(String token);
    String getTypeUser(String token);
}
