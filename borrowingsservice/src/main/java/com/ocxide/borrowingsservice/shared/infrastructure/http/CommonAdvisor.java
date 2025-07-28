package com.ocxide.borrowingsservice.shared.infrastructure.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonAdvisor {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Object handle(MethodArgumentNotValidException err) {
		var fields = err.getBindingResult().getFieldErrors();

		var errorsMap = new HashMap<String, List<String>>();
		for (var field : fields) {
			if (errorsMap.containsKey(field.getField())) {
				errorsMap.get(field.getField()).add(field.getDefaultMessage());
			} else {
				var errors = new ArrayList<String>();
				errors.add(field.getDefaultMessage());
				errorsMap.put(field.getField(), errors);
			}
		}

		return errorsMap;
	}
}
