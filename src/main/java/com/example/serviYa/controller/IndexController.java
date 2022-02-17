/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author daihan
 */
@Controller
public class IndexController {

    @GetMapping("/acceso")
    public String main() {
        return "acceso";
    }
 
    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }
    @GetMapping(value="/SalirAplicacion")
    public String customLogout(HttpServletRequest request, HttpServletResponse response) {
		this.invalidarUsuario(request, response);
		return "acceso";
    }
	
    protected void invalidarUsuario(HttpServletRequest request, HttpServletResponse response) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication != null){    
	        new SecurityContextLogoutHandler().logout(request, response, authentication);
	    }
	}


}
