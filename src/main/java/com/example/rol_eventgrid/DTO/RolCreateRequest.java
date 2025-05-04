package com.example.rol_eventgrid.DTO;

public class RolCreateRequest {
    private Long id;
    private String rol;

    public RolCreateRequest(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
}
