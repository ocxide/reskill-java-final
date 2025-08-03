package com.ocxide.notificationsservice.notifications.infrastructure.db;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import io.r2dbc.postgresql.codec.Interval;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveBorrowingsRepository extends ReactiveCrudRepository<BorrowingEntity, Long> {

	Mono<BorrowingEntity> findByBookCopyId(Long bookCopyId);

	@Query("SELECT * FROM borrowings WHERE expiration_notified = false AND ((borrowed_at + expires_past) - NOW()) <= :threshold")
	Flux<BorrowingEntity> findByNearExpiration(Interval threshold);
}
