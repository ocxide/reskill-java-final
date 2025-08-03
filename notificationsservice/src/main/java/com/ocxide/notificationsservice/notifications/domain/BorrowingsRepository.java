package com.ocxide.notificationsservice.notifications.domain;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BorrowingsRepository {
	Mono<Void> createOne(Borrowing borrowing);
	Mono<Borrowing> getOneByBookCopy(Long bookCopyId);
	Mono<Void> deleteOne(Long id);
	Flux<Borrowing> getAllNearExpiration(Duration threshold);
}
