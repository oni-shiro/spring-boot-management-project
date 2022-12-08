package com.sinchan.hibernateproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {

	@Bean
	public ModelMapper setModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		System.out.println("Bean is created \n\n\n");
		return modelMapper;
	}
}
