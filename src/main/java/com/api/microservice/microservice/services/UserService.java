package com.api.microservice.microservice.services;

import com.api.microservice.microservice.clients.UserClient;
import com.api.microservice.microservice.config.JwtToken;
import com.api.microservice.microservice.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    JwtToken jwtToken;

    @Autowired
    UserClient userClient;



    public Object getUsers() {
        return userClient.getAllUsers();
    }

    public String loginUser(String email, String password) {
        UserDto user = userClient.loginUser(email,password);

        if (user.getTypeUser().equalsIgnoreCase("ADMIN")){
            return jwtToken.generateToken(user.getEmail());
        }
        return "não passou";
    }
}
