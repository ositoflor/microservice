package com.api.microservice.microservice.controllers;

import com.api.microservice.microservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users", produces = "application/json")
    public Object getAllUsers() {
        return userService.getUsers();
    }
}
