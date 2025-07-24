package com.ocxide.booksservice.bookeditions.domain;

import reactor.core.publisher.Mono;

public interface BookEditionsRepository {

	Mono<Long> createOne(BookEdition bookEdition);
}
