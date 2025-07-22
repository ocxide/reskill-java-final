package com.ocxide.usersservice.auth.infrastructure.http;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.ocxide.usersservice.auth.domain.InvalidCredentialsError;
import com.ocxide.usersservice.auth.domain.UsernameAlreadyTakenError;

@ControllerAdvice
public class ExceptionResponseHandler {
	@ExceptionHandler(UsernameAlreadyTakenError.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<ErrorsReponse> handle(UsernameAlreadyTakenError e) {
		var response = new ErrorsReponse(List.of(e.getMessage()));
		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(InvalidCredentialsError.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseEntity<ErrorsReponse> handle(InvalidCredentialsError e) {
		var response = new ErrorsReponse(List.of(e.getMessage()));
		return ResponseEntity.badRequest().body(response);
	}
}

record ErrorsReponse(List<String> errors) {
}
