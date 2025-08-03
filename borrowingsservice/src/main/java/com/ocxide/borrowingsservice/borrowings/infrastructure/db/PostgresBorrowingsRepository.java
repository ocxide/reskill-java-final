package com.ocxide.borrowingsservice.borrowings.infrastructure.db;

import org.springframework.stereotype.Service;

import com.ocxide.borrowingsservice.borrowings.infrastructure.BorrowingsMapper;
import com.ocxide.borrowingsservice.borrowings.domain.Borrowing;
import com.ocxide.borrowingsservice.borrowings.domain.BorrowingsRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostgresBorrowingsRepository implements BorrowingsRepository {

	private final ReactiveBorrowingsRepository repository;
	private final BorrowingsMapper mapper;

	@Override
	public Mono<Borrowing> createOne(Borrowing borrowing) {
		return repository.save(mapper.toEntity(borrowing)).map(mapper::entityToDomain);
	}

	@Override
	public Flux<Borrowing> listPerUser(Long userId) {
		return repository.findAllByUserId(userId).map(mapper::entityToDomain);
	}

	@Override
	public Mono<Void> deleteOne(Long id) {
		return repository.deleteById(id);
	}

	@Override
	public Mono<Borrowing> getOne(Long id) {
		return repository.findById(id).map(mapper::entityToDomain);
	}

}
