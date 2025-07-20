package com.ocxide.usersservice.application;

import com.ocxide.usersservice.domain.User;

import reactor.core.publisher.Mono;

public interface UsersRepository {

	Mono<Void> createOne(User user);
}
