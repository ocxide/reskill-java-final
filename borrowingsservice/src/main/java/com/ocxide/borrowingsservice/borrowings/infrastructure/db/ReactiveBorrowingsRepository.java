package com.ocxide.borrowingsservice.borrowings.infrastructure.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveBorrowingsRepository extends ReactiveCrudRepository<BorrowingEntity, Long> {

}
