package com.api.microservice.microservice.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtToken {
    private final String secret =
            "A+X;fTJP&Pd,TD9dwVq(hsHX,ya^<wsD_UK7L+@=S;{'CydP]{v@}G'b>et;yz$*\\yL5S8EJN:%P:X%H9>#nYLrX}@\\s?CQcpspH,2emzBc!Q[V'AYa~uzF8WR~AUrMzxp/V$9([S9X#zj/CH('#]B_Hc+%fGhe27YB;^j4\\Xk=Ju\"Ap~_&<L;=!Z;!,2UP;!hF3P]j85#*`&T]/kB/W^6$v~u6qpejL>kY^f)sy4:qTq_Ec!-z!@aAp~sLKGU>$";

    public String generateToken(String email){
        return Jwts.builder().setIssuer("localhost:8081")
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + Long.parseLong("86400000")))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
}


