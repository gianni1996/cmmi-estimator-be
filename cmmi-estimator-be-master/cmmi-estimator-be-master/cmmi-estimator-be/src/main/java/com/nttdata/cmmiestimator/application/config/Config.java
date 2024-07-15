package com.nttdata.cmmiestimator.application.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.nttdata" })
public class Config {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
