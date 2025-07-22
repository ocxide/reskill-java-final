package com.ocxide.usersservice.auth.infrastructure.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface IReactiveUsersRepository extends ReactiveCrudRepository<UserEntity, Long> {
	Mono<UserEntity> findByUsername(String username);
	
}
