package com.ocxide.notificationsservice.notifications.infrastructure.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface ReactiveBorrowingsRepository extends ReactiveCrudRepository<BorrowingEntity, Long> {

	Mono<BorrowingEntity> findByBookCopyId(Long bookCopyId);
}
