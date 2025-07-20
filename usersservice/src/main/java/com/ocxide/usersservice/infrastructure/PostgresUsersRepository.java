package com.ocxide.usersservice.infrastructure;

import org.springframework.stereotype.Repository;

import com.ocxide.usersservice.application.UsersRepository;
import com.ocxide.usersservice.domain.User;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class PostgresUsersRepository implements UsersRepository {

	private final IReactiveUsersRepository repository;
	private final UserMapper userMapper;

	@Override
	public Mono<Void> createOne(User user) {
		return repository.save(userMapper.toEntity(user)).then();
	}

}
