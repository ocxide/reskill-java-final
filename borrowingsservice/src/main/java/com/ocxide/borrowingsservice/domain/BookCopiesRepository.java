package com.ocxide.borrowingsservice.domain;

import java.util.Optional;

import reactor.core.publisher.Mono;

public interface BookCopiesRepository {

	Mono<Optional<BookCopy>> getOne(Long id);
}
