package com.ocxide.notificationsservice.notifications.infrastructure.db;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.ocxide.notificationsservice.notifications.domain.Borrowing;
import com.ocxide.notificationsservice.notifications.domain.BorrowingsRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostgresBorrowingsRepository implements BorrowingsRepository {
	private final SqlBorrowingsMapper mapper;
	private final ReactiveBorrowingsRepository repository;

	@Override
	public Mono<Void> createOne(Borrowing borrowing) {
		var entity = mapper.toEntity(borrowing);
		return repository.save(entity).then();
	}

	@Override
	public Mono<Void> deleteOne(Long id) {
		return repository.deleteById(id).then();
	}

	@Override
	public Mono<Borrowing> getOneByBookCopy(Long bookCopyId) {
		return repository.findByBookCopyId(bookCopyId)
				.map(mapper::toDomain);
	}

	@Override
	public Flux<Borrowing> getAllNearExpiration(Duration threshold) {
		return repository.findByNearExpiration(mapper.toInterval(threshold))
				.map(mapper::toDomain);
	}

}
