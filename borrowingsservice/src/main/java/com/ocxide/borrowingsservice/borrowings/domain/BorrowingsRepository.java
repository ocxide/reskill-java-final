package com.ocxide.borrowingsservice.borrowings.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BorrowingsRepository {

	Mono<Borrowing> createOne(Borrowing borrowing);

	Flux<Borrowing> listPerUser(Long userId);

	Mono<Void> deleteOne(Long id);

	Mono<Borrowing> getOne(Long id);
}
