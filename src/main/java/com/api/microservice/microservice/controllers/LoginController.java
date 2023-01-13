package com.api.microservice.microservice.controllers;

import com.api.microservice.microservice.dtos.LoginDto;
import com.api.microservice.microservice.dtos.TokenDto;
import com.api.microservice.microservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping(value = "login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(loginDto));
    }
}
