package com.ocxide.booksservice.bookeditions.application;

import com.ocxide.booksservice.bookeditions.domain.BookEdition;
import com.ocxide.booksservice.bookeditions.domain.BookEditionsRepository;

import reactor.core.publisher.Mono;

public record CreateOneUseCase(BookEditionsRepository repository) {

	public Mono<Void> run(BookEdition edition) {
		return repository.createOne(edition);
	}
}
