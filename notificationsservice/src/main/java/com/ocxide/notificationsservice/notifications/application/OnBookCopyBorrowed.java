package com.ocxide.notificationsservice.notifications.application;

import com.ocxide.notificationsservice.notifications.domain.Borrowing;
import com.ocxide.notificationsservice.notifications.domain.BorrowingsRepository;
import com.ocxide.notificationsservice.notifications.domain.Notificator;

import reactor.core.publisher.Mono;

public record OnBookCopyBorrowed(BorrowingsRepository repository, Notificator notificator) {

	public Mono<Void> run(Borrowing borrowing) {
		return repository.createOne(borrowing).then(notificator.onBorrowed(borrowing));
	}
}
