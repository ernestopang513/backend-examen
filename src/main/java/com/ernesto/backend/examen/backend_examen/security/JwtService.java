package com.ernesto.backend.examen.backend_examen.security;

import static com.ernesto.backend.examen.backend_examen.security.TokenJwtConfig.SECRET_KEY;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtService {

    public String generateToken(Authentication authentication) {
        try {
            String username = authentication.getName();
            var roles = authentication.getAuthorities();

            Claims claims = Jwts.claims()
                .add("authorities", new ObjectMapper().writeValueAsString(roles))
                .add("username", username)
                .build();

            return Jwts.builder()
                .subject(username)
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .issuedAt(new Date())
                .signWith(SECRET_KEY)
                .compact();

        } catch (Exception e) {
            throw new RuntimeException("Error generando token");
        }
    }
}
