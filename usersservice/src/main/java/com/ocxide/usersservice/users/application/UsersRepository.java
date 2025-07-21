package com.ocxide.usersservice.users.application;

import com.ocxide.usersservice.auth.domain.User;

import reactor.core.publisher.Mono;

public interface UsersRepository {

	Mono<Void> createOne(User user);
}
