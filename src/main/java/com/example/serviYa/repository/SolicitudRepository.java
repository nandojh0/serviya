/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.serviYa.repository;

import com.example.serviYa.dominio.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author daihan
 */
public interface SolicitudRepository extends JpaRepository<Solicitud, Long>
{
    
}
