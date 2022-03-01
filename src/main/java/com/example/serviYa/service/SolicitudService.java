/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.serviYa.service;

import com.example.serviYa.controller.dto.Respuesta;
import com.example.serviYa.dominio.Solicitud;
import java.util.List;

/**
 *
 * @author daihan
 */
public interface SolicitudService {
    
     List<Solicitud> todos();
//    Cliente getCliente(Long idCliente);

    Respuesta<Solicitud> save(Solicitud solicitud);

    Respuesta<Solicitud> modificar(Solicitud solicitud);

    Respuesta<Void> eliminar(Long id);
    
}
