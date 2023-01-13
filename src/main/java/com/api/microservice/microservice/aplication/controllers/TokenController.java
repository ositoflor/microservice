package com.api.microservice.microservice.aplication.controllers;

import com.api.microservice.microservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class TokenController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/validatetoken")
    public boolean validateToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        String tkn =  token.split(" ")[1];
        return userService.validateToken(tkn);
    }

    @GetMapping(value = "/typeuser")
    public String getTypeUser(@RequestHeader(HttpHeaders.AUTHORIZATION)String token) {
        String tkn =  token.split(" ")[1];
        return userService.getTypeUser(tkn);
    }
}
