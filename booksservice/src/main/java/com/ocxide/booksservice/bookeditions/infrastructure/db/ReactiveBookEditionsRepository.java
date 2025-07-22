package com.ocxide.booksservice.bookeditions.infrastructure.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveBookEditionsRepository extends ReactiveCrudRepository<BookEditionEntity, Long> {

}
