/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.controller;

import com.example.serviYa.dominio.Usuario;
import com.example.serviYa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author daihan
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository usuarios;
    
    @Autowired 
    private PasswordEncoder encoder;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated @ModelAttribute("usuario")Usuario user, BindingResult result) {
        
        if(result.hasErrors()) {
            return "usuario";
        }
        
     // calcular el HASH de la contraseña
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        
        usuarios.save(user);
        
        return "redirect:/index";
    }

   
}