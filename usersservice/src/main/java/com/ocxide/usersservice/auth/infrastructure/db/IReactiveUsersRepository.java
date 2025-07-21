package com.ocxide.usersservice.auth.infrastructure.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IReactiveUsersRepository extends ReactiveCrudRepository<UserEntity, Long> {
	
}
