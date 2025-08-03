package com.ocxide.notificationsservice.notifications.application;

import com.ocxide.notificationsservice.notifications.domain.BookCopyReturned;
import com.ocxide.notificationsservice.notifications.domain.BorrowingsRepository;
import com.ocxide.notificationsservice.notifications.domain.Notificator;

import reactor.core.publisher.Mono;

public record OnBookCopyReturnedUseCase(BorrowingsRepository repository, Notificator notificator) {
	public Mono<Void> run(Long bookCopyId) {
		return repository.getOneByBookCopy(bookCopyId)
				.flatMap(borrowing -> {
					var delete = repository.deleteOne(borrowing.id());
					return notificator.onReturned(new BookCopyReturned(borrowing)).then(delete);
				});
	}
}
