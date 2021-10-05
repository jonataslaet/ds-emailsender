package com.devsuperior.dsemailsender.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devsuperior.dsemailsender.services.SendgridServiceDev;

@Configuration
@Profile("dev")
public class DevConfig {

	@Bean
	public SendgridServiceDev getSendgridServiceDev() {
		return new SendgridServiceDev();
	}
}
