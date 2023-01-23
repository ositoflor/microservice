package com.api.microservice.microservice.infra.clients;

import com.api.microservice.microservice.domain.Login;
import com.api.microservice.microservice.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class UserClient {
    @Value(value = "${uri.user}")
    String URI;
    RestTemplate restTemplate = new RestTemplate();

    public User login(Login login){
        var result = restTemplate.postForEntity(URI, login, User.class);
        return result.getBody();
    }

}
