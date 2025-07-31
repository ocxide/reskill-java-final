package com.ocxide.booksservice.bookcopies.infrastructure.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ocxide.booksservice.bookcopies.domain.BookCopiesRepository;
import com.ocxide.booksservice.bookcopies.domain.BookCopy;
import com.ocxide.booksservice.bookcopies.infrastructure.BookCopiesMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Repository
public class PostgresBookCopiesRepository implements BookCopiesRepository {
	private final ReactiveBookCopiesRepository repository;
	private final BookCopiesMapper mapper;

	@Override
	public Mono<Long> createOne(BookCopy bookCopy) {
		return repository.save(mapper.toEntity(bookCopy)).map(e -> e.getId());
	}

	@Override
	public Mono<Optional<BookCopy>> getOne(Long id) {
		return repository.findById(id).map(entity -> Optional.of(mapper.entityToDomain(entity)))
				.switchIfEmpty(Mono.just(Optional.empty()));
	}

	@Override
	public Mono<Void> updateOne(Long id, BookCopy copy) {
		var entity = mapper.toEntity(copy);
		entity.setId(id);

		return repository.save(entity).then();
	}

	@Override
	public Flux<BookCopy> findAllByEditionId(Long editionId) {
		return repository.findAllByBookEditionId(editionId).map(mapper::entityToDomain);
	}
}
