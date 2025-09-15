package com.ernesto.backend.examen.backend_examen.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ernesto.backend.examen.backend_examen.models.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
