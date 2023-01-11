package com.api.microservice.microservice.clients;

import com.api.microservice.microservice.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(value = "feignUsers", url = "http://localhost:8082/user")
public interface UserClient {

    @GetMapping
    Object getAllUsers();

    @GetMapping(value = "/login/{email}/password/{password}")
    UserDto loginUser(@PathVariable(value = "email")String email, @PathVariable(value = "password")String password);

}
