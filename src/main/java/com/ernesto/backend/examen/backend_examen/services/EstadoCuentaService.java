package com.ernesto.backend.examen.backend_examen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ernesto.backend.examen.backend_examen.repositories.EstadoCuentaRepository;
import com.ernesto.backend.examen.backend_examen.repositories.UserRepository;
import com.ernesto.backend.examen.models.dtos.CrearEstadoCuentaDto;
import com.ernesto.backend.examen.models.entities.EstadoCuenta;
import com.ernesto.backend.examen.models.entities.User;

@Service
public class EstadoCuentaService {

    @Autowired
    private EstadoCuentaRepository estadoCuentaRepository;

    @Autowired UserRepository userRepository;

    public EstadoCuenta crear(CrearEstadoCuentaDto dto) {
        User user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));


        EstadoCuenta estadoCuenta = new EstadoCuenta();
        estadoCuenta.setUser(user);
        estadoCuenta.setEstado("PENDIENTE");
        return estadoCuentaRepository.save(estadoCuenta);
    }

     public List<EstadoCuenta> findAll() {
        return (List<EstadoCuenta>)estadoCuentaRepository.findAll();
    }

    public Optional<EstadoCuenta> findById(Long id) {
        return estadoCuentaRepository.findById(id);
    }

    public void removeById(Long id) {
        estadoCuentaRepository.deleteById(id);
    }

    
}
