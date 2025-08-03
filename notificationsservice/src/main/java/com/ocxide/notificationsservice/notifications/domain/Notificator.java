package com.ocxide.notificationsservice.notifications.domain;

import reactor.core.publisher.Mono;

public interface Notificator {

	Mono<Void> onBorrowed(BookCopyBorrowed borrowing);
	Mono<Void> onReturned(BookCopyReturned borrowing);
	Mono<Void> onNearExpiration(BookCopyNearExpiration borrowing);
}
