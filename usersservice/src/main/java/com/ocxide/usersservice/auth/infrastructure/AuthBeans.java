package com.ocxide.usersservice.auth.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ocxide.usersservice.auth.application.RegisterUseCase;
import com.ocxide.usersservice.auth.application.SignInUseCase;
import com.ocxide.usersservice.auth.domain.UsersRepository;
import com.ocxide.usersservice.auth.domain.ClaimsEncoder;
import com.ocxide.usersservice.auth.domain.PasswordVerifier;

@Configuration
public class AuthBeans {

	@Bean
	PasswordVerifier verifier() {
		return new PlainPasswordVerifier();
	}

	@Bean
	SignInUseCase signInUseCase(UsersRepository repository, ClaimsEncoder encoder, PasswordVerifier verifier) {
		return new SignInUseCase(repository, encoder, verifier);
	}

	@Bean
	RegisterUseCase registerUseCase(UsersRepository repository) {
		return new RegisterUseCase(repository);
	}
}
