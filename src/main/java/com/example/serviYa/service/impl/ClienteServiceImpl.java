/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.service.impl;

import com.example.serviYa.dominio.Cliente;
import com.example.serviYa.repository.ClienteRepository;
import com.example.serviYa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author daihan
 */
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public Cliente getCliente(Long idCliente) {
        return clienteRepository.findByIdCliente(idCliente);
    }

    @Override
    public Cliente save(Cliente idCliente) {
       return clienteRepository.save(idCliente); 
    }
    
}
