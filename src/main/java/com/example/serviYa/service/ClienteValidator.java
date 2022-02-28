/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.service;

import com.example.serviYa.util.Validator;
import com.example.serviYa.dominio.Cliente;
import com.example.serviYa.util.Notificacion;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 *
 * @author daihan
 */
@Component
public class ClienteValidator implements Validator<Cliente> {

    @Override
    public Notificacion validate(Cliente cliente) throws IllegalAccessException {

        final Notificacion notificacion = new Notificacion();

        if (nombreValido(cliente.getNombreCliente())) {
            notificacion.addError("El nombre no puede contener numeros ");
        }

        return notificacion;
    }

    public Boolean nombreValido(String nombre) {
        return Pattern.compile("[0-9]").matcher(nombre).find();
    }

    public Boolean fechaValida(Date fecha) {
        Calendar fechaComparar = Calendar.getInstance();
        fechaComparar.setTime(fecha);
        return !fechaComparar.after(Calendar.getInstance());
    }

}
