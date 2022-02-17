/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.converter;

import com.example.serviYa.controller.dto.ClienteDTO;
import com.example.serviYa.dominio.Cliente;
/**
 *
 * @author daihan
 */
public class ClienteConverter {

    public ClienteConverter() {
        throw new IllegalStateException("Utility class");
    }
    
    public static Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setDni(clienteDTO.getDni());
        cliente.setNombreCliente(clienteDTO.getNombreCliente());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setDirrecion(clienteDTO.getDirrecion());
        cliente.setIdUsuario(clienteDTO.getIdUsuario());
        return cliente;
    }
    public static ClienteDTO toDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setDni(cliente.getDni());
		clienteDTO.setNombreCliente(cliente.getNombreCliente());
		clienteDTO.setTelefono(cliente.getTelefono());
		clienteDTO.setDirrecion(cliente.getDirrecion());
		clienteDTO.setIdUsuario(cliente.getIdUsuario());
		return clienteDTO;
	}
}
