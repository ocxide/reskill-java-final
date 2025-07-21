package com.ocxide.usersservice.auth.infrastructure.db;

import org.springframework.stereotype.Service;

import com.ocxide.usersservice.auth.domain.AuthRepository;
import com.ocxide.usersservice.auth.domain.AuthUser;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostgresAuthRepository implements AuthRepository {
	private final ReactiveAuthRepository repository;

	@Override
	public Mono<AuthUser> getAuthUser(String username) {
		return repository.findByUsername(username);
	}

}
