/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.serviYa.service;
import com.example.serviYa.dominio.Cliente;
import java.util.List;
/**
 *
 * @author daihan
 */
public interface ClienteService {
    Cliente getCliente(Long idCliente);
    Cliente save(Cliente idCliente);
}
