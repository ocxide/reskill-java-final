package com.ocxide.notificationsservice.notifications.infrastructure.db;

import org.springframework.stereotype.Service;

import com.ocxide.notificationsservice.notifications.domain.Borrowing;
import com.ocxide.notificationsservice.notifications.domain.BorrowingsRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostgresBorrowingsRepository implements BorrowingsRepository {
	private final ReactiveBorrowingsRepository repository;

	@Override
	public Mono<Void> createOne(Borrowing borrowing) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createOne'");
	}

	@Override
	public Mono<Void> deleteOne(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteOne'");
	}

	
}
