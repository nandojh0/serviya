/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.serviYa.service;

import com.example.serviYa.controller.dto.Respuesta;
import com.example.serviYa.dominio.Cliente;
import java.util.List;

/**
 *
 * @author daihan
 */
public interface ClienteService {

    List<Cliente> todos();
//    Cliente getCliente(Long idCliente);

    Respuesta<Cliente> save(Cliente cliente);

    Respuesta<Cliente> modificar(Cliente cliente);

    Respuesta<Void> eliminar(Long id);
}
