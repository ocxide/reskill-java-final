package com.ocxide.borrowingsservice.application;

import com.ocxide.borrowingsservice.domain.BookCopiesRepository;
import com.ocxide.borrowingsservice.domain.BookCopyNotAvailable;
import com.ocxide.borrowingsservice.domain.BookCopyNotFound;
import com.ocxide.borrowingsservice.domain.Borrowing;
import com.ocxide.borrowingsservice.domain.BorrowingsNotificator;
import com.ocxide.borrowingsservice.domain.BorrowingsRepository;
import com.ocxide.borrowingsservice.domain.CopyStatus;

import reactor.core.publisher.Mono;

public record CreateOneUseCase(BookCopiesRepository bookCopiesRepository, BorrowingsRepository borrowingsRepository,
		BorrowingsNotificator notificator) {
	public Mono<Void> createOne(Borrowing borrowing) {
		return bookCopiesRepository.getOne(borrowing.bookCopyId()).flatMap(response -> {
			if (response.isEmpty())
				return Mono.error(new BookCopyNotFound());
			var copy = response.get();

			if (copy.status() != CopyStatus.Available)
				return Mono.error(new BookCopyNotAvailable());

			return borrowingsRepository.createOne(borrowing);
		})
				.flatMap(v -> notificator.onCopyBorrowed(borrowing));
	}
}
