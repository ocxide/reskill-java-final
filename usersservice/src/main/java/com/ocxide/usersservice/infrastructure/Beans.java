package com.ocxide.usersservice.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ocxide.usersservice.application.CreateOneService;
import com.ocxide.usersservice.application.UsersRepository;

@Configuration
public class Beans {
	@Bean
	CreateOneService createOneService(UsersRepository repository) {
		return new CreateOneService(repository);
	}
}
