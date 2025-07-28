package com.ocxide.borrowingsservice.borrowings.infrastructure.http;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import com.ocxide.borrowingsservice.borrowings.domain.BookCopyNotAvailable;
import com.ocxide.borrowingsservice.borrowings.domain.BookCopyNotFound;

@RestControllerAdvice
public class BorrowingsAdvicer {

	@ExceptionHandler(BookCopyNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleBookNotFound(BookCopyNotFound e) {
	}

	@ExceptionHandler(BookCopyNotAvailable.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public void handleBookCopyNotAvailable(BookCopyNotAvailable e) {
	}
}
