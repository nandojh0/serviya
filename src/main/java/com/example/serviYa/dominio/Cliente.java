/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author daihan
 */

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long idCliente;
    
    @Column(name = "DNI")
    private Long dni;
    
    @Column(name = "NOMBRE")
    private String nombreCliente;
    
    @Column(name = "TELEFONO")
    private String telefono;
    
    
    @Column(name = "DIRRECION")
    private String direccion;
    
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    
    @OneToOne
    @JoinColumn(name = "ID_USUARIO", insertable = false,updatable = false)
    private Usuario usuario;

    public Cliente() {
         super();
    }

    public Cliente(Long idCliente, Long dni, String nombreCliente, String telefono, String direccion, Long idUsuario, Usuario usuario) {
        super();
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
    }

    public Cliente(Long idCliente, Long dni, String nombreCliente, String telefono, String direccion) {
        super();
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
