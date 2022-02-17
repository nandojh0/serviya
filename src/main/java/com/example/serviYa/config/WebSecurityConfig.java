/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.config;


import com.example.serviYa.repository.UserRepository;
import com.example.serviYa.service.impl.ControladorAutenticacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author daihan
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    
        @Autowired
	private UserRepository userRepository;
    
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return new ControladorAutenticacion(userRepository);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/js/**","/css/**","/user/**","usuario","/acceso","/login").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
			.loginPage("/acceso")
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/index")
			.failureUrl("/acceso?error=true")
			.successHandler(konectaMgaAuthenticationSuccessHandler())
			.and()
			.logout()
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.logoutUrl("SalirAplicacion")
			.logoutSuccessUrl("/acceso")
			.permitAll();
	}

	@Bean
	public SimpleUrlAuthenticationSuccessHandler konectaMgaAuthenticationSuccessHandler() {
		return new SimpleUrlAuthenticationSuccessHandler("/index");
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
//	 @Override
//	 @Bean
//	 public AuthenticationManager authenticationManagerBean() throws Exception {
//	        return super.authenticationManagerBean();
//	    }
	 

	
	
	

}
