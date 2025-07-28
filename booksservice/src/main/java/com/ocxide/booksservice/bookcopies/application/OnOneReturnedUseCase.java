package com.ocxide.booksservice.bookcopies.application;

import com.ocxide.booksservice.bookcopies.domain.BookCopiesRepository;
import com.ocxide.booksservice.bookcopies.domain.BookCopy;
import com.ocxide.booksservice.bookcopies.domain.BookCopyNotFound;
import com.ocxide.booksservice.bookcopies.domain.CopyStatus;

import reactor.core.publisher.Mono;

public record OnOneReturnedUseCase(BookCopiesRepository repository) {

	public Mono<Void> run(Long id) {
		return repository.getOne(id).flatMap(response -> {
			if (response.isEmpty()) {
				return Mono.error(new BookCopyNotFound());
			}

			var copy = response.get();

			copy = new BookCopy(copy.bookEditionId(), CopyStatus.Available, copy.ingressedAt());

			return repository.updateOne(id, copy);
		});
	}
}
