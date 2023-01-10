package com.api.microservice.microservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "feignProduct", url = "http://localhost:8080/products")
public interface ProductClient {

    @PostMapping(value = "/cadastrar")
    Object postProduct(Object product);
    @GetMapping
    Object getProducts();

}
