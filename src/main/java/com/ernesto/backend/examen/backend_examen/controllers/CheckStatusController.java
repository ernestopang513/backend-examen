package com.ernesto.backend.examen.backend_examen.controllers;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ernesto.backend.examen.backend_examen.security.JwtService;


@RestController
@RequestMapping("/check-status")
public class CheckStatusController {

    private final JwtService jwtService;

    public CheckStatusController(JwtService jwtService) {
        this.jwtService = jwtService;
    }



    @GetMapping
    public ResponseEntity<?> checkStatus(Authentication authentication) {

        if(authentication == null || !authentication.isAuthenticated() ) {
            return ResponseEntity.status(401).body(Map.of("error", "Usuario no autenticado"));
        } 

        String newToken = jwtService.generateToken(authentication);
        String username = authentication.getName();

        var principal = authentication.getPrincipal();
        System.out.println(principal);
        var roles = authentication.getAuthorities();
        System.out.println(roles);

        //  com.ernesto.backend.examen.backend_examen.models.entities.User user =
        //     (com.ernesto.backend.examen.backend_examen.models.entities.User) authentication.getPrincipal();
        // System.out.println(user);

        return ResponseEntity.ok(Map.of(
            "message", "Token renovado correctamente",
            "token", newToken,
            "username", username
        ));

        // return ResponseEntity.ok().build();
    }
}
