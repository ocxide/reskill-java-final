package com.ocxide.borrowingsservice.borrowings.application;

import com.ocxide.borrowingsservice.borrowings.domain.Borrowing;
import com.ocxide.borrowingsservice.borrowings.domain.BorrowingsRepository;

import reactor.core.publisher.Flux;

public record ListPerUserUseCase(BorrowingsRepository repository) {
	public Flux<Borrowing> listPerUser(Long userId) {
		return repository.listPerUser(userId);
	}
}
