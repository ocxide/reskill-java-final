package com.ocxide.usersservice.application;

import com.ocxide.usersservice.domain.User;

import reactor.core.publisher.Mono;

public record CreateOneService(UsersRepository repository) {
	public Mono<Void> createOne(User user) {
		return repository.createOne(user);
	}
}
