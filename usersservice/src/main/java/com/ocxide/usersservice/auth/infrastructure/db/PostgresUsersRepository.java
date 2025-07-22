package com.ocxide.usersservice.auth.infrastructure.db;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.ocxide.usersservice.auth.domain.UsersRepository;
import com.ocxide.usersservice.auth.domain.AuthUser;
import com.ocxide.usersservice.auth.domain.User;
import com.ocxide.usersservice.auth.domain.UsernameAlreadyTakenError;
import com.ocxide.usersservice.auth.infrastructure.UserMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class PostgresUsersRepository implements UsersRepository {

	private final IReactiveUsersRepository repository;
	private final UserMapper userMapper;

	@Override
	public Mono<Void> createOne(User user) {
		return repository.save(userMapper.toEntity(user))
				.onErrorMap(DataIntegrityViolationException.class, e -> new UsernameAlreadyTakenError(user.username()))
				.then();
	}

	@Override
	public Mono<AuthUser> getAuthUser(String username) {
		return repository.findByUsername(username)
				.map(userMapper::toAuthUser);
	}

}
