package com.ernesto.backend.examen.backend_examen.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check-status")
public class CheckStatusController {

    @GetMapping
    public ResponseEntity<?> checkStatus(Authentication authentication) {
        return ResponseEntity.ok().build();
    }
}
