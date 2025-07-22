package com.ocxide.usersservice.auth.infrastructure.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ocxide.usersservice.auth.application.RegisterUseCase;
import com.ocxide.usersservice.auth.application.SignInUseCase;
import com.ocxide.usersservice.auth.infrastructure.UserMapper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
	private final RegisterUseCase createOneService;
	private final SignInUseCase signInService;
	private final UserMapper userMapper;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/")
	public Mono<Void> createOne(@RequestBody @Valid CreateUserDTO body) {
		var user = userMapper.fromDto(body);
		return createOneService.run(user);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/signin")
	public Mono<String> signIn(@RequestBody @Valid SignInDTO body) {
		return signInService.run(body.username(), body.password());
	}
}
