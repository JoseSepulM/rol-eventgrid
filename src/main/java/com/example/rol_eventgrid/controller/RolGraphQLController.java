package com.example.rol_eventgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import com.example.rol_eventgrid.DTO.RolUpdateRequest;
import com.example.rol_eventgrid.service.EventGridPublisherService;

@Controller
public class RolGraphQLController {

    @Autowired
    private EventGridPublisherService publisherService;

    @MutationMapping
    public String updateRol(@Argument String id, @Argument RolUpdateRequest input) {
        publisherService.publishEvent("RolActualizado", "/rol/" + id, input);
        return "Rol actualizado";
    }

}
