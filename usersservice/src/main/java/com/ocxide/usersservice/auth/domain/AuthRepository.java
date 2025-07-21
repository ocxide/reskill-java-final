package com.ocxide.usersservice.auth.domain;

import reactor.core.publisher.Mono;

public interface AuthRepository {
	Mono<AuthUser> getAuthUser(String username);	
}
