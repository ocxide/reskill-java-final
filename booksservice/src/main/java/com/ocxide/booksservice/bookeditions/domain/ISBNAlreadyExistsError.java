package com.ocxide.booksservice.bookeditions.domain;

public class ISBNAlreadyExistsError extends Exception {
	public ISBNAlreadyExistsError(String isbn) {
		super("ISBN `" + isbn + "` already exists");
	}
}
