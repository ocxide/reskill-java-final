package com.ocxide.booksservice.bookeditions.infrastructure.http;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.ocxide.booksservice.bookeditions.domain.ISBNAlreadyExistsError;

@ControllerAdvice
public class BookEditionsAdvicer {
	@ExceptionHandler(ISBNAlreadyExistsError.class)	
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleISBNAlreadyExists(ISBNAlreadyExistsError error) {
		return error.getMessage();
	}
}
