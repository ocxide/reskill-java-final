package com.ocxide.notificationsservice.notifications.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ocxide.notificationsservice.notifications.application.OnBookCopyBorrowedUseCase;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KafkaBorrowingEventsListener {
	private final KafkaBorrowingEventsMapper mapper;
	private final OnBookCopyBorrowedUseCase onBookCopyBorrowed;

	@KafkaListener(topics = "bookcopies.borrow")
	public void onBorrowingEvent(BookCopyBorrowedEvent event) {
		onBookCopyBorrowed.run(mapper.toDomain(event)).subscribe(v -> {
		}, err -> {
			System.out.println(err.getMessage());
		});
	}
}
