package com.ocxide.booksservice.bookcopies.infrastructure.db;

import org.springframework.stereotype.Repository;

import com.ocxide.booksservice.bookcopies.domain.BookCopiesRepository;
import com.ocxide.booksservice.bookcopies.domain.BookCopy;
import com.ocxide.booksservice.bookcopies.infrastructure.BookCopiesMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Repository
public class PostgresBookCopiesRepository implements BookCopiesRepository {
	private final ReactiveBookCopiesRepository repository;
	private final BookCopiesMapper mapper;

	@Override
	public Mono<Void> createOne(BookCopy bookCopy) {
		return repository.save(mapper.toEntity(bookCopy)).then();
	}

}
