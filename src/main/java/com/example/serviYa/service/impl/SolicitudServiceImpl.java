/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.serviYa.service.impl;

import com.example.serviYa.controller.dto.Respuesta;
import com.example.serviYa.dominio.Solicitud;
import com.example.serviYa.service.SolicitudService;
import java.util.List;

/**
 *
 * @author daihan
 */
public class SolicitudServiceImpl implements SolicitudService {

    @Override
    public List<Solicitud> todos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Respuesta<Solicitud> save(Solicitud solicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Respuesta<Solicitud> modificar(Solicitud solicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Respuesta<Void> eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
