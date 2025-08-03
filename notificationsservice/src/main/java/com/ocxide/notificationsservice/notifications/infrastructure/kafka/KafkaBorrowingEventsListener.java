package com.ocxide.notificationsservice.notifications.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ocxide.notificationsservice.notifications.application.OnBookCopyBorrowedUseCase;
import com.ocxide.notificationsservice.notifications.application.OnBookCopyReturnedUseCase;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KafkaBorrowingEventsListener {
	private final KafkaBorrowingEventsMapper mapper;
	private final OnBookCopyBorrowedUseCase onBookCopyBorrowed;
	private final OnBookCopyReturnedUseCase onBookCopyReturned;

	@KafkaListener(topics = "bookcopies.borrow")
	public void onBorrowingEvent(BookCopyBorrowedEvent event) {
		System.out.println("GOT EVENT bookcopies.borrow: " + event.id());
		onBookCopyBorrowed.run(mapper.toDomain(event)).subscribe(v -> {
		}, err -> {
			System.out.println(err.getMessage());
		});
	}

	@KafkaListener(topics = "bookcopies.return")
	public void onReturnEvent(Long bookCopyId) {
		System.out.println("GOT EVENT bookcopies.return: " + bookCopyId);
		onBookCopyReturned.run(bookCopyId).subscribe(v -> {
		}, err -> {
			System.out.println(err.getMessage());
		});
	}
}
