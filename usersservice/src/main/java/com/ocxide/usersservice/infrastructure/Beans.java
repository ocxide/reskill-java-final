package com.ocxide.usersservice.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ocxide.usersservice.application.CreateOneService;

@Configuration
public class Beans {
	@Bean
	public CreateOneService createOneService() {
		return new CreateOneService();
	}
}
