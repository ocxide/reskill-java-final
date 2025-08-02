package com.ocxide.notificationsservice.notifications.domain;

import reactor.core.publisher.Mono;

public interface Notificator {

	Mono<Void> onBorrowed(Borrowing borrowing);
}
