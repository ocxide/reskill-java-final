package com.ocxide.booksservice.bookeditions.infrastructure.db;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.ocxide.booksservice.bookeditions.domain.BookEdition;
import com.ocxide.booksservice.bookeditions.domain.BookEditionsRepository;
import com.ocxide.booksservice.bookeditions.domain.ISBNAlreadyExistsError;
import com.ocxide.booksservice.bookeditions.infrastructure.BookEditionsMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class PostgresBookEditionsRepository implements BookEditionsRepository {

	private final ReactiveBookEditionsRepository repository;
	private final BookEditionsMapper mapper;

	@Override
	public Mono<Long> createOne(BookEdition bookEdition) {
		var entity = mapper.toEntity(bookEdition);
		return repository.save(entity)
				.onErrorMap(DataIntegrityViolationException.class, e -> new ISBNAlreadyExistsError(bookEdition.isbn()))
				.map(e -> e.getId());
	}

	@Override
	public Flux<BookEdition> findAll() {
		return repository.findAll()
				.map(mapper::toDomain);
	}

}
