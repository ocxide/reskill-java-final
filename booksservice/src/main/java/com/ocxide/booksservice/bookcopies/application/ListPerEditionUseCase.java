package com.ocxide.booksservice.bookcopies.application;

import com.ocxide.booksservice.bookcopies.domain.BookCopiesRepository;
import com.ocxide.booksservice.bookcopies.domain.BookCopy;

import reactor.core.publisher.Flux;

public record ListPerEditionUseCase(BookCopiesRepository repository) {

	public Flux<BookCopy> run(Long editionId) {
		return repository.findAllByEditionId(editionId);
	}
}
