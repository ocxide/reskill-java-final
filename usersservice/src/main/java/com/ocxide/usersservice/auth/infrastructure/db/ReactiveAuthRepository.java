package com.ocxide.usersservice.auth.infrastructure.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ocxide.usersservice.auth.domain.AuthUser;

import reactor.core.publisher.Mono;

public interface ReactiveAuthRepository extends ReactiveCrudRepository<AuthUser, Long> {
	Mono<AuthUser> findByUsername(String username);

}
