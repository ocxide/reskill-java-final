package com.ocxide.booksservice.bookcopies.application;

import com.ocxide.booksservice.bookcopies.domain.BookCopiesRepository;
import com.ocxide.booksservice.bookcopies.domain.BookCopy;
import com.ocxide.booksservice.bookcopies.domain.BookCopyNotAvailable;
import com.ocxide.booksservice.bookcopies.domain.BookCopyNotFound;
import com.ocxide.booksservice.bookcopies.domain.CopyStatus;

import reactor.core.publisher.Mono;

public record BorrowOneUseCase(BookCopiesRepository repository) {

	public Mono<Void> run(Long id) {
		return repository.getOne(id).flatMap(response -> {
			if (response.isEmpty()) {
				return Mono.error(new BookCopyNotFound());
			}
			
			var copy = response.get();
			if (copy.status() != CopyStatus.Available) return Mono.error(new BookCopyNotAvailable());
			
			copy = new BookCopy(copy.bookEditionId(), CopyStatus.Borrowed, copy.ingressedAt());

			return repository.updateOne(id, copy);
		});
	}
}
