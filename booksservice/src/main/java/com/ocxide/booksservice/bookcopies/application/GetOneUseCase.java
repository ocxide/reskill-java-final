package com.ocxide.booksservice.bookcopies.application;

import com.ocxide.booksservice.bookcopies.domain.BookCopiesRepository;
import com.ocxide.booksservice.bookcopies.domain.BookCopy;
import com.ocxide.booksservice.bookcopies.domain.BookCopyNotFound;

import reactor.core.publisher.Mono;

public record GetOneUseCase(BookCopiesRepository repository) {

	public Mono<BookCopy> run(Long id) {
		return repository.getOne(id)
		.handle((response, sink) -> {
			
			if(response.isEmpty()) {
				sink.error(new BookCopyNotFound());
				return;
			}
			
			sink.next(response.get());
			sink.complete();
		});
	}
}
