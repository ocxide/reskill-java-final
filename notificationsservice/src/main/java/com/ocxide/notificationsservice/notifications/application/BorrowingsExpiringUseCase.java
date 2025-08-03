package com.ocxide.notificationsservice.notifications.application;

import java.time.Duration;

import com.ocxide.notificationsservice.notifications.domain.BorrowingsRepository;
import com.ocxide.notificationsservice.notifications.domain.Notificator;

import reactor.core.publisher.Mono;

public record BorrowingsExpiringUseCase(
		Duration threshold,
		BorrowingsRepository repository,
		Notificator notificator) {

	public Mono<Void> run() {
		return repository.getAllNearExpiration(threshold)
				.flatMap(borrowing -> {
					var delete = repository.deleteOne(borrowing.id());
					return notificator.onNearExpiration(borrowing).then(delete);
				}).then();
	}
}
