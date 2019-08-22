package com.mateus.sistema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mateus.sistema.services.DBService;

@Configuration
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public void instantiateDatabase () {
		dbService.instantiateTestDatabase();
	}
}
