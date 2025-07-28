package com.ocxide.borrowingsservice.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BorrowingsRepository {

	Mono<Long> createOne(Borrowing borrowing);

	Flux<Borrowing> listPerUser(Long userId);

	Mono<Void> deleteOne(Long id);

	Mono<Borrowing> getOne(Long id);
}
