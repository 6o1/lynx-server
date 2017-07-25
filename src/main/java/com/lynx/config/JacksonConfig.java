package com.lynx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

@Configuration
public class ApplicationConfig {

	@Bean
	public Module afterburnerModule() {
		return new AfterburnerModule();
	}

}
