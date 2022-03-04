/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.controller;

import com.example.serviYa.controller.dto.ClienteDTO;
import com.example.serviYa.controller.dto.Respuesta;
import com.example.serviYa.converter.ClienteConverter;
import com.example.serviYa.service.ClienteService;
import java.util.List;
import com.example.serviYa.dominio.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author daihan
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService empleadoService;

    @GetMapping("/todos")
    public List<Cliente> todos() {
        return empleadoService.todos();
    }

    @PostMapping
    public Respuesta<Cliente> save(@RequestBody ClienteDTO clienteDTO) {
        return empleadoService.save(ClienteConverter.toEntity(clienteDTO));
    }

//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @PutMapping("/modificar")
    public Respuesta<Cliente> modificar(@RequestBody ClienteDTO clienteDTO) {
        return empleadoService.modificar(ClienteConverter.toEntity(clienteDTO));
    }

    @DeleteMapping("/{id}")
    public Respuesta<Void> eliminar(@PathVariable(name = "id") Long id) {
        return empleadoService.eliminar(id);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Respuesta<Void> manejadorExcepciones(AccessDeniedException e) {
        return new Respuesta<>(Boolean.FALSE, "El usuario no tiene permisos para realizar esta operación", 403, null);
    }
}
