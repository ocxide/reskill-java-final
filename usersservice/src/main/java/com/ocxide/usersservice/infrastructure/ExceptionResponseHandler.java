package com.ocxide.usersservice.infrastructure;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ocxide.usersservice.domain.UsernameAlreadyTakenError;

@ControllerAdvice
public class ExceptionResponseHandler {
	@ExceptionHandler(UsernameAlreadyTakenError.class)
	public ResponseEntity<ErrorsReponse> handle(UsernameAlreadyTakenError e) {
		var response = new ErrorsReponse(List.of(e.getMessage()));
		return ResponseEntity.badRequest().body(response);
	}
	
}

record ErrorsReponse(List<String> errors) {}
