package com.ocxide.usersservice.application;

import com.ocxide.usersservice.domain.User;

import reactor.core.publisher.Mono;

public class CreateOneService {
	public Mono<Void> createOne(User user) {
		return Mono.just(1).then();
	}
}
