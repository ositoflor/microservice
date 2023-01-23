package com.api.microservice.microservice.service;

import com.api.microservice.microservice.AplicationConfigTest;
import com.api.microservice.microservice.domain.Login;
import com.api.microservice.microservice.domain.User;
import com.api.microservice.microservice.infra.clients.UserClient;
import com.api.microservice.microservice.services.impl.UserServiceImpl;
import com.api.microservice.microservice.services.dto.TokenDto;
import com.api.microservice.microservice.services.jwt.JwtToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("ServiceTest")
public class ServiceTest  extends AplicationConfigTest {

    @MockBean
    JwtToken jwtToken;

    @MockBean
    UserClient userClient;

    @Autowired
    UserServiceImpl userService;

    @Test
    public void testLogin() {
        var login = mock(Login.class);
        var user = mock(User.class);
        when(userClient.login(ArgumentMatchers.eq(login))).thenReturn(user);

        when(jwtToken.generateToken(ArgumentMatchers.eq(user))).thenReturn("token");

        TokenDto tokenDto =  userService.loginUser(login);

        assertNotNull(tokenDto);
        assertEquals("Bearer", tokenDto.getType());
        assertEquals("token", tokenDto.getToken());

        verify(userClient).login(login);
        verify(jwtToken).generateToken(user);
    }

    @Test
    public void testValidateToken() {
        when(jwtToken.tokenValid(anyString())).thenReturn(true);
        assertTrue(userService.validateToken("token"));
    }

    @Test void testTypeUser() {
        when(jwtToken.typeUser(anyString())).thenReturn("admin");
        assertEquals("admin",userService.getTypeUser("token"));
    }


}
