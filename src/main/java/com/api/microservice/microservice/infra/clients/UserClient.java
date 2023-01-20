package com.api.microservice.microservice.infra.clients;

import com.api.microservice.microservice.domain.Login;
import com.api.microservice.microservice.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class UserClient {
    String URI = "http://localhost:8082/user/login";
    RestTemplate restTemplate = new RestTemplate();

    public User login(Login login){
        var result = restTemplate.postForEntity(URI, login, User.class);
        return result.getBody();
    }

}
