package com.ocxide.notificationsservice.notifications.domain;

import reactor.core.publisher.Mono;

public interface BorrowingsRepository {
	Mono<Void> createOne(Borrowing borrowing);
	Mono<Void> deleteOne(Long id);
}
