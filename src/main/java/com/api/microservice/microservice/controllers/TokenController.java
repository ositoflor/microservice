package com.api.microservice.microservice.controllers;

import com.api.microservice.microservice.dtos.TokenDto;
import com.api.microservice.microservice.dtos.UserDto;
import com.api.microservice.microservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class TokenController {

    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<TokenDto> loginUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(userDto));
    }


    @GetMapping(value = "/validatetoken")
    public boolean validateToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        String tkn =  token.split(" ")[1];
        return true;
    }

    @GetMapping(value = "/typeuser")
    public String getTypeUser(@RequestHeader(HttpHeaders.AUTHORIZATION)String token) {
        String tkn =  token.split(" ")[1];
        return userService.getTypeUser(tkn);
    }
}
