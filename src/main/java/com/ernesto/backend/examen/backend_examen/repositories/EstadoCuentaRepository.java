package com.ernesto.backend.examen.backend_examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ernesto.backend.examen.backend_examen.models.entities.EstadoCuenta;


public interface EstadoCuentaRepository extends JpaRepository<EstadoCuenta, Long> {

    List<EstadoCuenta> findByUserId(Long userId);
    List<EstadoCuenta> findByUserUsernameAndEstado(String username, String estado);
}
