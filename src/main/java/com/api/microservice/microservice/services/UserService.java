package com.api.microservice.microservice.services;

import com.api.microservice.microservice.clients.UserClient;
import com.api.microservice.microservice.dtos.LoginDto;
import com.api.microservice.microservice.dtos.TokenDto;
import com.api.microservice.microservice.jwt.JwtToken;
import com.api.microservice.microservice.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    JwtToken jwtToken;

    @Autowired
    UserClient userClient;

    public TokenDto loginUser(LoginDto loginDto) {
       UserDto user = userClient.loginUser(loginDto);
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
