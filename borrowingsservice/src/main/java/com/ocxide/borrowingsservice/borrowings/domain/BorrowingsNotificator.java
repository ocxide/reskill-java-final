package com.ocxide.borrowingsservice.borrowings.domain;

import reactor.core.publisher.Mono;

public interface BorrowingsNotificator {

	Mono<Void> onCopyBorrowed(Borrowing borrowing);	
	Mono<Void> onCopyReturned(Borrowing borrowing);
}
