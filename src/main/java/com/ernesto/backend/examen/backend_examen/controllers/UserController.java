package com.ernesto.backend.examen.backend_examen.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ernesto.backend.examen.backend_examen.models.dtos.CreateUserDto;
import com.ernesto.backend.examen.backend_examen.models.dtos.LoginDto;
import com.ernesto.backend.examen.backend_examen.models.dtos.UserResponseDto;
import com.ernesto.backend.examen.backend_examen.models.entities.User;
import com.ernesto.backend.examen.backend_examen.services.UserServiceImp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImp userService;

     

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDTO){
        Optional<User> userOpt = userService.login(loginDTO.getUsername(),loginDTO.getPassword());
        if(userOpt.isPresent()){
            UserResponseDto userResponseDto = userService.toResponseDto(userOpt.orElseThrow());
            return ResponseEntity.ok(userResponseDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<UserResponseDto> list() {
        return userService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
        
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateUserDto createUserDto) {
        Optional<User> userOpt = userService.save(createUserDto);
        if(userOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(userOpt);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre de usuario ya esta en uso.");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CreateUserDto createUserDto) {
        createUserDto.setIsAdmin(false);
        return create(createUserDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CreateUserDto user, @PathVariable Long id) {
        Optional<User> o = userService.update(user, id);
        if(o.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(o.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Optional<User> o = userService.findById(id);
        if(o.isPresent()) {
            userService.remove(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }

}

