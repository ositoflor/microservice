package com.api.microservice.microservice.service;

import com.api.microservice.microservice.AplicationConfigTest;
import com.api.microservice.microservice.domain.Login;
import com.api.microservice.microservice.domain.User;
import com.api.microservice.microservice.infra.clients.UserClient;
import com.api.microservice.microservice.services.UserService;
import com.api.microservice.microservice.services.dto.TokenDto;
import com.api.microservice.microservice.services.jwt.JwtToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ServiceTest")
public class ServiceTest  extends AplicationConfigTest {

    @MockBean
    JwtToken jwtToken;

    @MockBean
    UserClient userClient;

    @Autowired
    UserService userService;

    @Test
    public void testLogin() {
        Login loginUser = new Login("ositoteste@teste.com","123456789");
        User user = new User("ositoteste@teste.com","Osito teste","99966633312","ADMIN");
        Mockito.when(userClient.loginUser(ArgumentMatchers.eq(loginUser))).thenReturn(user);

        Mockito.when(jwtToken.generateToken(ArgumentMatchers.eq(user))).thenReturn("token");

        TokenDto tokenDto =  userService.loginUser(loginUser);

        assertNotNull(tokenDto);
        assertEquals("Bearer", tokenDto.getType());
        assertEquals("token", tokenDto.getToken());
        Mockito.verify(userClient).loginUser(loginUser);
        Mockito.verify(jwtToken).generateToken(user);
    }


}
