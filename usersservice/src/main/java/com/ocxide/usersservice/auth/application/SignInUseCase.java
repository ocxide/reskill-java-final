package com.ocxide.usersservice.auth.application;

import com.ocxide.usersservice.auth.domain.UsersRepository;
import com.ocxide.usersservice.auth.domain.ClaimsEncoder;
import com.ocxide.usersservice.auth.domain.InvalidCredentialsError;
import com.ocxide.usersservice.auth.domain.PasswordVerifier;
import com.ocxide.usersservice.auth.domain.UserPayload;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class SignInUseCase {
	private final UsersRepository repository;
	private final ClaimsEncoder encoder;
	private final PasswordVerifier verifier;

	public Mono<String> run(String username, String password) {
		return repository.getAuthUser(username).handle((user, sink) -> {
			var equal = verifier.verify(password, user.password());
			if (!equal) {
				sink.error(new InvalidCredentialsError());
				return;
			}

			var token = encoder.encode(new UserPayload(user.id(), user.username()));
			sink.next(token);
			sink.complete();
		});
	}
}
