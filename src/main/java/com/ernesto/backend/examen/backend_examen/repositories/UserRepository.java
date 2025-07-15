package com.ernesto.backend.examen.backend_examen.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ernesto.backend.examen.backend_examen.models.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
