package com.ocxide.borrowingsservice.borrowings.infrastructure.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface ReactiveBorrowingsRepository extends ReactiveCrudRepository<BorrowingEntity, Long> {
	Flux<BorrowingEntity> findAllByUserId(Long userId);
}
