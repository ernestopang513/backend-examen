package com.ernesto.backend.examen.backend_examen.models.dtos;


public class UserResponseDto {
    private Long id;
    private String username;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
}
