package com.ocxide.borrowingsservice.domain;

import reactor.core.publisher.Mono;

public interface BorrowingsRepository {
	Mono<Long> createOne(Borrowing borrowing);
}
