package com.api.microservice.microservice.clients;

import com.api.microservice.microservice.dtos.LoginDto;
import com.api.microservice.microservice.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "feignUsers", url = "http://localhost:8082/user")
public interface UserClient {

    @PostMapping(value = "/login")
    UserDto loginUser(@RequestBody LoginDto loginDto);

}
