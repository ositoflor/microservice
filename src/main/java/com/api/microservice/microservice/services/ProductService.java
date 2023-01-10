package com.api.microservice.microservice.services;

import com.api.microservice.microservice.clients.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

    @Autowired
    ProductClient productClient;


    public Object postProduct(Object product) {
        return productClient.postProduct(product);
    }

    public Object getProduct() {
        return productClient.getProducts();
    }

}
