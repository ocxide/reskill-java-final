package com.ocxide.borrowingsservice.borrowings.infrastructure.db;

import org.springframework.stereotype.Service;

import com.ocxide.borrowingsservice.borrowings.infrastructure.BorrowingsMapper;
import com.ocxide.borrowingsservice.domain.Borrowing;
import com.ocxide.borrowingsservice.domain.BorrowingsRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostgresBorrowingsRepository implements BorrowingsRepository {

	private final ReactiveBorrowingsRepository repository;
	private final BorrowingsMapper mapper;

	@Override
	public Mono<Void> createOne(Borrowing borrowing) {
		return repository.save(mapper.toEntity(borrowing))
				.then();
	}

	
}
