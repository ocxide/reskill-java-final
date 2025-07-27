package com.ocxide.booksservice.bookcopies.domain;

import java.util.Optional;

import reactor.core.publisher.Mono;

public interface BookCopiesRepository {

	Mono<Long> createOne(BookCopy bookCopy);

	Mono<Optional<BookCopy>> getOne(Long id);

	Mono<Void> updateOne(Long id, BookCopy copy);
}
