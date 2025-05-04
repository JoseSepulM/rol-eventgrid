package com.example.rol_eventgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rol_eventgrid.DTO.RolCreateRequest;
import com.example.rol_eventgrid.DTO.RolUpdateRequest;
import com.example.rol_eventgrid.service.EventGridPublisherService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/rol")
public class RolController {
    
    @Autowired
    private EventGridPublisherService publisherService;

   @PostMapping
    public ResponseEntity<String> createRol(@RequestBody RolCreateRequest request) {
        publisherService.publishEvent("RolCreado", "/rol", request);
        return ResponseEntity.ok("Rol creado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRol(@PathVariable String id, @RequestBody RolUpdateRequest request) {
        publisherService.publishEvent("RolActualizado", "/rol/" + id, request);
        return ResponseEntity.ok("Rol actualizado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable String id, @RequestBody String entity) {
        publisherService.publishEvent("RolEliminado", "/rol/" + id, entity);
        return ResponseEntity.ok("Rol eliminado y evento publicado.");
    }

    @GetMapping
    public ResponseEntity<String> getRoles(@RequestParam String param) {
        publisherService.publishEvent("RolConsultado", "/rol?param=" + param, param);
        return ResponseEntity.ok("Evento de consulta enviado.");
    }
    


}
