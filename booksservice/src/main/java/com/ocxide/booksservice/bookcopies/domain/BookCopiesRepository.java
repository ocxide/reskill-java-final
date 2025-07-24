package com.ocxide.booksservice.bookcopies.domain;

import reactor.core.publisher.Mono;

public interface BookCopiesRepository {

	Mono<Long> createOne(BookCopy bookCopy);
}
