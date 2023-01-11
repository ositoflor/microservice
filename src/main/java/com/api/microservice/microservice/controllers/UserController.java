package com.api.microservice.microservice.controllers;

import com.api.microservice.microservice.dtos.TokenDto;
import com.api.microservice.microservice.dtos.UserDto;
import com.api.microservice.microservice.dtos.UserLoginDto;
import com.api.microservice.microservice.services.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@RestController
@RequestMapping("demo")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users", produces = "application/json")
    public Object getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<TokenDto> loginUser(@RequestBody UserLoginDto userDto) {
        String token = userService.loginUser(userDto.getEmail(), userDto.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(TokenDto.builder().type("Bearer").token(token).build());
    }

}
