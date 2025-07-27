package com.ocxide.borrowingsservice.borrowings.infrastructure.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ocxide.borrowingsservice.domain.Borrowing;
import com.ocxide.borrowingsservice.domain.BorrowingsNotificator;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class KafkaBorrowingsNotificator implements BorrowingsNotificator {
	private final KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public Mono<Void> onCopyBorrowed(Borrowing borrowing) {
		var fut = kafkaTemplate.send("bookcopies.borrow", borrowing.bookCopyId().toString());
		return Mono.fromFuture(fut).then();
	}

}
