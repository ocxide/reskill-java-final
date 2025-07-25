package com.ocxide.booksservice.bookcopies.infrastructure.http;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.ocxide.booksservice.bookcopies.domain.BookCopyNotFound;

@ControllerAdvice
public class BookCopiesAdvicer {
	
	@ExceptionHandler(BookCopyNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleNotFoundException() {
	}
	
}
