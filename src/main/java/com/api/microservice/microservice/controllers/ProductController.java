package com.api.microservice.microservice.controllers;

import com.api.microservice.microservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping(value = "/product/cadastrar", produces = "application/json")
    public ResponseEntity<Object> postProducts(@RequestBody Object product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.postProduct(product));
    }

    @GetMapping(value = "/product/getall", produces = "application/json")
    public ResponseEntity<Object> getProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct());
    }
}
