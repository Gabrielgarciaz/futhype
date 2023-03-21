package com.gabrielgarcia.futhype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Permitir acesso a qualquer requisição 
		http.headers().frameOptions().disable(); // Liberando aceedo ao banco de dados h2
		http.csrf().disable(); // Liberar proteção csrf
		return http.build();
	}

}
