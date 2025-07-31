package com.ocxide.booksservice.bookcopies.infrastructure.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface ReactiveBookCopiesRepository extends ReactiveCrudRepository<BookCopyEntity, Long> {
	Flux<BookCopyEntity> findAllByBookEditionId(Long editionId);
}
