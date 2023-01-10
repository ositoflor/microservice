package com.api.microservice.microservice.services;

import com.api.microservice.microservice.clients.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserClient userClient;

    public Object getUsers() {
        return userClient.getAllUsers();
    }
}
