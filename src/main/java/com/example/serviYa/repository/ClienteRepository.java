/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.serviYa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.serviYa.dominio.Cliente;
/**
 *
 * @author daihan
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    Cliente findByIdCliente(Long idCliente);
}
