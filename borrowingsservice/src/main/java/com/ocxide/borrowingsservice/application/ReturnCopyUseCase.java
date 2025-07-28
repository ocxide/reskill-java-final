package com.ocxide.borrowingsservice.application;

import com.ocxide.borrowingsservice.domain.BorrowingsNotificator;
import com.ocxide.borrowingsservice.domain.BorrowingsRepository;

import reactor.core.publisher.Mono;

public record ReturnCopyUseCase(BorrowingsRepository repository, BorrowingsNotificator notificator) {

	public Mono<Void> run(Long borrowingId) {
		return repository.getOne(borrowingId).flatMap(borrowing -> {
			return repository.deleteOne(borrowingId).switchIfEmpty(notificator.onCopyReturned(borrowing));
		});
	}
}
