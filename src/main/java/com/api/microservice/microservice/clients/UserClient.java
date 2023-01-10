package com.api.microservice.microservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "feignUsers", url = "http://localhost:8082/user")
public interface UserClient {

    @GetMapping
    Object getAllUsers();

}
