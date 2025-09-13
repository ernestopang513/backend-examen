package com.ernesto.backend.examen.backend_examen.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ernesto.backend.examen.backend_examen.models.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
