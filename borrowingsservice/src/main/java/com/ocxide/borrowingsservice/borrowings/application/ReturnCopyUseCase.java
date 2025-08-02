package com.ocxide.borrowingsservice.borrowings.application;

import com.ocxide.borrowingsservice.borrowings.domain.BorrowingsNotificator;
import com.ocxide.borrowingsservice.borrowings.domain.BorrowingsRepository;

import reactor.core.publisher.Mono;

public record ReturnCopyUseCase(BorrowingsRepository repository, BorrowingsNotificator notificator) {

	public Mono<Void> run(Long borrowingId) {
		return repository.getOne(borrowingId).flatMap(borrowing -> {
			return repository.deleteOne(borrowingId).switchIfEmpty(notificator.onCopyReturned(borrowing));
		});
	}
}
