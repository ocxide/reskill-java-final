package com.ocxide.booksservice.bookcopies.infrastructure.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveBookCopiesRepository extends ReactiveCrudRepository<BookCopyEntity, Long> {
}
