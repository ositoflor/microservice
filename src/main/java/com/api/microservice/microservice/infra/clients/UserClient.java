package com.api.microservice.microservice.infra.clients;

import com.api.microservice.microservice.domain.Login;
import com.api.microservice.microservice.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "feignUsers", url = "http://localhost:8082/user")
public interface UserClient {

    @PostMapping(value = "/login")
    User loginUser(@RequestBody Login loginDto);

}
