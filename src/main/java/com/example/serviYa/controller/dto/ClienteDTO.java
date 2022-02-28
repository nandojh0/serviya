/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.controller.dto;

/**
 *
 * @author daihan
 */
public class ClienteDTO {
  
    private Long idCliente;
    private Long dni;
    private String nombreCliente;
    private String telefono;
    private String dirrecion;
    private Long idUsuario;

    public ClienteDTO(Long idCliente, Long dni, String nombreCliente, String telefono, String dirrecion) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.dirrecion = dirrecion;
    }

    public ClienteDTO() {
    }
    
    
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
