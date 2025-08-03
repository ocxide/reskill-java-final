package com.ocxide.notificationsservice.notifications.application;

import java.time.Duration;

import com.ocxide.notificationsservice.notifications.domain.BookCopyNearExpiration;
import com.ocxide.notificationsservice.notifications.domain.BorrowingsRepository;
import com.ocxide.notificationsservice.notifications.domain.Notificator;

import reactor.core.publisher.Mono;

public record BorrowingsNearExpirationUseCase(
		Duration threshold,
		BorrowingsRepository repository,
		Notificator notificator) {

	public Mono<Void> run() {
		System.out.println("threshold: " + threshold);
		return repository.getAllNearExpiration(threshold)
				.flatMap(borrowing -> {

					borrowing = borrowing.withExpirationNotified(true);

					var update = repository.updateOne(borrowing);
					return notificator.onNearExpiration(new BookCopyNearExpiration(borrowing)).then(update);
				}).then();
	}
}
