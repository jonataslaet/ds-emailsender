package com.devsuperior.dsemailsender.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devsuperior.dsemailsender.services.SendgridServiceTest;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	public SendgridServiceTest getSendgridServiceTest() {
		return new SendgridServiceTest();
	}
}
