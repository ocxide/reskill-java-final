package com.ocxide.booksservice.bookeditions.application;

import com.ocxide.booksservice.bookeditions.domain.BookEdition;
import com.ocxide.booksservice.bookeditions.domain.BookEditionsRepository;

import reactor.core.publisher.Flux;

public record ListAllUseCase(BookEditionsRepository repository) {

	public Flux<BookEdition> run() {
		return repository.findAll();
	}
}
