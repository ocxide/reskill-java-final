package com.ocxide.usersservice.auth.domain;

import reactor.core.publisher.Mono;

public interface UsersRepository {
	Mono<AuthUser> getAuthUser(String username);	
	Mono<Void> createOne(User user);
}
