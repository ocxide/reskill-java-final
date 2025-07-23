package com.ocxide.booksservice.bookcopies.domain;

import reactor.core.publisher.Mono;

public interface BookCopiesRepository {

	Mono<Void> createOne(BookCopy bookCopy);
}
