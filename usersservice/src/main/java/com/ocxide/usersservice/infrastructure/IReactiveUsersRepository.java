package com.ocxide.usersservice.infrastructure;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IReactiveUsersRepository extends ReactiveCrudRepository<UserEntity, Long> {
	
}
