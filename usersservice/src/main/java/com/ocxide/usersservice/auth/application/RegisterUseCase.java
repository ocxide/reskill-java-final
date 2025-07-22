package com.ocxide.usersservice.auth.application;

import org.springframework.stereotype.Service;

import com.ocxide.usersservice.auth.domain.UsersRepository;
import com.ocxide.usersservice.auth.domain.User;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RegisterUseCase {
	private final UsersRepository repository;

	public Mono<Void> run(User user) {
		return repository.createOne(user);
	}
}
