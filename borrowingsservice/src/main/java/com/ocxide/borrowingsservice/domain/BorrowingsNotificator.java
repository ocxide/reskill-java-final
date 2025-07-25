package com.ocxide.borrowingsservice.domain;

import reactor.core.publisher.Mono;

public interface BorrowingsNotificator {

	Mono<Void> onCopyBorrowed(Borrowing borrowing);	
}
