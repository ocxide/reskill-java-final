package com.ocxide.usersservice.users.infrastructure;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IReactiveUsersRepository extends ReactiveCrudRepository<UserEntity, Long> {
	
}
