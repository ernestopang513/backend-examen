package com.ernesto.backend.examen.backend_examen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ernesto.backend.examen.backend_examen.models.dtos.CreateUserDto;
import com.ernesto.backend.examen.backend_examen.models.dtos.UserResponseDto;
import com.ernesto.backend.examen.backend_examen.models.entities.User;
import com.ernesto.backend.examen.backend_examen.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

     public Optional<User> login(String username, String password){
        Optional<User> userOpt = userRepository.findByUsername(username);
        if(userOpt.isPresent() && userOpt.get().getPassword().equals(password)){
            return userOpt;
        }
        return Optional.empty();
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> save(CreateUserDto createUserDto) {
        Optional<User> userOpt = userRepository.findByUsername(createUserDto.getUsername());
        if(userOpt.isPresent()){
            return Optional.empty();
        }

        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setPassword(createUserDto.getPassword());

        return Optional.of(userRepository.save(user));
    }

    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> update(CreateUserDto user, Long id) {
        Optional<User> o = findById(id);
        User userOptional = null;
        if (o.isPresent()) {
            User userDB = o.orElseThrow();
            userDB.setUsername(user.getUsername());
            userOptional = userRepository.save(userDB);
        }
        return Optional.ofNullable(userOptional);
    }


    public UserResponseDto toResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());

        return dto;
    }
}
