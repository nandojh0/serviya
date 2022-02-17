/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.serviYa.repository;

import com.example.serviYa.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author daihan
 */
public interface UserRepository extends JpaRepository<Usuario, Long>{

    Usuario findByNombre(String nombre);
    
    Usuario findByNombreAndPassword(String nombre,String password);
    
//    @Query(value="select * from usuario u where u.NOMBRE=? and u.PASSWORD=?")
//    Usuario login(String nombre,String password);
}
