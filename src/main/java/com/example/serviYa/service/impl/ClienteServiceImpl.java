/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.service.impl;

import com.example.serviYa.controller.dto.Respuesta;
import com.example.serviYa.dominio.Cliente;
import com.example.serviYa.repository.ClienteRepository;
import com.example.serviYa.service.ClienteService;
import com.example.serviYa.service.ClienteValidator;
import com.example.serviYa.util.DocumentManager;
import com.example.serviYa.util.Notificacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nando jh
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private DocumentManager doc;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteValidator empleadoValidator;

    private Notificacion notificacion;

    @Override
    public List<Cliente> todos() {
        return clienteRepository.findAll();
    }

//    @Override
//    public Cliente getCliente(Long idCliente) {
//        return clienteRepository.findByIdCliente(idCliente);
//    }
    @Override
    public Respuesta<Cliente> save(Cliente cliente) {
        try {
            this.notificacion = empleadoValidator.validate(cliente);

            if (!this.notificacion.hasErrors()) {
                return new Respuesta<>(clienteRepository.save(cliente));
            } else {
                return new Respuesta<>(Boolean.FALSE, this.notificacion.getError());
            }
        } catch (Exception e) {
            doc.write(1, doc.getCurrentTime() + " " + "Error en /cliente/save  excepcion: " + e);
            return new Respuesta<>(Boolean.FALSE, "Error en la guardar al cliente");
        }
    }

    @Override
    public Respuesta<Cliente> modificar(Cliente cliente) {
        try {
            this.notificacion = empleadoValidator.validate(cliente);

            if (!this.notificacion.hasErrors()) {
                return new Respuesta<>(clienteRepository.save(cliente));
            } else {
                return new Respuesta<>(Boolean.FALSE, this.notificacion.getError());
            }
        } catch (Exception e) {
            doc.write(1, doc.getCurrentTime() + " " + "Error en /cliente/modificar  excepcion: " + e);
            return new Respuesta<>(Boolean.FALSE, "Error al modificar el cliente");
        }
    }

    @Override
    public Respuesta<Void> eliminar(Long id) {
        try {
            if (clienteRepository.existsById(id)) {
                clienteRepository.deleteById(id);
                return new Respuesta<>(Boolean.TRUE, "Se elimin\u00F3 el empleado");
            } else {
                return new Respuesta<>(Boolean.FALSE, "El cliente no existe");
            }
        } catch (Exception e) {
            doc.write(1, doc.getCurrentTime() + " " + "Error en /cliente/eliminar  excepcion: " + e);
            return new Respuesta<>(Boolean.FALSE, "Ocurri\u00F3 un error al eliminar el cliente", 1, null);
        }
    }

}
