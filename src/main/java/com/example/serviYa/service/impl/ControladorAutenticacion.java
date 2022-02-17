/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.service.impl;

/**
 *
 * @author daihan
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.serviYa.dominio.Usuario;
import com.example.serviYa.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ControladorAutenticacion implements AuthenticationManager {

    private final UserRepository userRepository;
    
     @Autowired 
    private PasswordEncoder encoder;
    
    public ControladorAutenticacion(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
    
	@Override
	public Authentication authenticate(Authentication authentication) {
		
		String userName = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		validate(userName);
		
		Usuario user = userRepository.findByNombre(userName);
		
		if (user == null) {
			throw new UsernameNotFoundException(userName);
	    }
                System.out.print("Conraseña cifrada: "+user.getPassword());
//                boolean result = encoder.matches(password, user.getPassword());
//		if (!encoder.matches(password, user.getPassword())) {
//                throw new BadCredentialsException("Error al ingresar: "+password);
//                }
		if (false) {
			throw new BadCredentialsException("Credenciales erroneas");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("OTRO"));
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(password, "", authorities);
		usernamePasswordAuthenticationToken.setDetails(new User(userName, "", true, true, true, true, authorities));
		
		return usernamePasswordAuthenticationToken;
	}
	
	/**
	 * @param userName
	 */
	protected void validate(String userName) {
		if (userName.length() < 3) {
			throw new BadCredentialsException("El usuario debe tener como mínimo 4 caracteres.");
		}
	}
}

