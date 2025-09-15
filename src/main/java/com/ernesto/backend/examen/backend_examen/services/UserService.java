package com.ernesto.backend.examen.backend_examen.services;

import java.util.List;
import java.util.Optional;

import com.ernesto.backend.examen.backend_examen.models.dtos.CreateUserDto;
import com.ernesto.backend.examen.backend_examen.models.dtos.UserResponseDto;
import com.ernesto.backend.examen.backend_examen.models.entities.EstadoCuenta;
import com.ernesto.backend.examen.backend_examen.models.entities.User;

public interface UserService {

    List<UserResponseDto> findAll();

    Optional<User> save(CreateUserDto user);

    boolean existsByUsername(String username);

    Optional<User> findById(Long id);

    void remove(Long id);

    Optional<User> update(CreateUserDto user, Long id);

    List<EstadoCuenta> findEstadosCuentaByUsername(String username);



}
