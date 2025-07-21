package com.ocxide.usersservice.auth.infrastructure.http;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ocxide.usersservice.auth.infrastructure.UserMapper;
import com.ocxide.usersservice.users.application.CreateOneService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
	private final CreateOneService createOneService;
	private final UserMapper userMapper;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/")
	public Mono<Void> createOne(@RequestBody @Valid CreateUserDTO body) {
		var user = userMapper.fromDto(body);
		return createOneService.createOne(user);
	}
}
