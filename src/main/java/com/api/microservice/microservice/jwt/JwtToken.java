package com.api.microservice.microservice.jwt;

import com.api.microservice.microservice.dtos.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtToken {
    private final String secret =
            "5efae338-e687-4472-9465-5c6bf14d3d32";

    public String generateToken(UserDto userDto){
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", userDto.getEmail());
        claims.put("name", userDto.getName());
        claims.put("typeUser", userDto.getTypeUser());
        claims.put("cpf", userDto.getCpf());

        return Jwts.builder().setIssuer("localhost:8081")
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + Long.parseLong("86400000")))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean tokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String typeUser(String token){
        try{
            Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return body.values().toString();

        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}


