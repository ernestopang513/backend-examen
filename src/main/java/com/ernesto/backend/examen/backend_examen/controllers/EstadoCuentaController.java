package com.ernesto.backend.examen.backend_examen.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ernesto.backend.examen.backend_examen.models.dtos.CrearEstadoCuentaDto;
import com.ernesto.backend.examen.backend_examen.models.dtos.UdateCuentaEstadoDto;
import com.ernesto.backend.examen.backend_examen.models.entities.EstadoCuenta;
import com.ernesto.backend.examen.backend_examen.services.EstadoCuentaService;

@RestController
@RequestMapping("/api/estado-cuenta")
public class EstadoCuentaController {
    @Autowired
    private EstadoCuentaService estadoCuentaService;


     @PostMapping
    public ResponseEntity<EstadoCuenta> crear(@RequestBody CrearEstadoCuentaDto estadoCuentaDto) {
        EstadoCuenta estadoCuenta = estadoCuentaService.crear(estadoCuentaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoCuenta);
    }

     @GetMapping
    public ResponseEntity<?> findAll() {
        List<EstadoCuenta> contratos = estadoCuentaService.findAll();
        if(contratos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(contratos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<EstadoCuenta> o = estadoCuentaService.findById(id);
        if(o.isPresent()) {
            return ResponseEntity.ok(o.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UdateCuentaEstadoDto contrato, @PathVariable Long id) {
        Optional<EstadoCuenta> o = estadoCuentaService.update(contrato, id);
        if(o.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(o.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeById(@PathVariable Long id) {
        Optional<EstadoCuenta> o = estadoCuentaService.findById(id);
        if(o.isPresent()) {
            estadoCuentaService.removeById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
