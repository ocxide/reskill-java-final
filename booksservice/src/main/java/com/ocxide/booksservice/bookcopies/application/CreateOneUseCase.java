package com.ocxide.booksservice.bookcopies.application;

import com.ocxide.booksservice.bookcopies.domain.BookCopiesRepository;
import com.ocxide.booksservice.bookcopies.domain.BookCopy;

import reactor.core.publisher.Mono;

public record CreateOneUseCase(BookCopiesRepository repository) {

	public Mono<Void> run(BookCopy copy) {
		return repository.createOne(copy);
	}
}
