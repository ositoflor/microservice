package com.api.microservice.microservice.services;

import com.api.microservice.microservice.dtos.TokenDto;
import com.api.microservice.microservice.jwt.JwtToken;
import com.api.microservice.microservice.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    JwtToken jwtToken;

    public TokenDto loginUser(UserDto userDto) {
       String token = jwtToken.generateToken(userDto);
       return TokenDto.builder().type("Bearer").token(token).build();
    }

    public boolean validateToken(String token) {
        System.out.print(token);
      return jwtToken.tokenValid(token);
    }

    public String getTypeUser(String token) {
        return jwtToken.typeUser(token);
    }
}
