package com.ernesto.backend.examen.models.dtos;

public class CrearEstadoCuentaDto {
    private String estado;
    private Long userId;
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
}
