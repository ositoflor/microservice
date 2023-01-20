package com.api.microservice.microservice.services;

import com.api.microservice.microservice.infra.clients.UserClient;
import com.api.microservice.microservice.domain.Login;
import com.api.microservice.microservice.services.dto.TokenDto;
import com.api.microservice.microservice.services.jwt.JwtToken;
import com.api.microservice.microservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    JwtToken jwtToken;

    @Autowired
    UserClient userClient;

    public TokenDto loginUser(Login loginDto) {
       User user = userClient.login(loginDto);
       if (user == null) {
           throw new RuntimeException("Usuário inválido");
       }
       String token = jwtToken.generateToken(user);

       return TokenDto.builder().type("Bearer").token(token).build();
    }

    public boolean validateToken(String token) {
      return jwtToken.tokenValid(token);
    }

    public String getTypeUser(String token) {
        return jwtToken.typeUser(token);
    }
}
