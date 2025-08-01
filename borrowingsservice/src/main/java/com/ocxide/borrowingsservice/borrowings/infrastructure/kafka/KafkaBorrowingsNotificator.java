package com.ocxide.borrowingsservice.borrowings.infrastructure.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ocxide.borrowingsservice.borrowings.domain.Borrowing;
import com.ocxide.borrowingsservice.borrowings.domain.BorrowingsNotificator;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class KafkaBorrowingsNotificator implements BorrowingsNotificator {
	private final KafkaMapper mapper;
	private final KafkaTemplate<String, CopyBorrowedDTO> borrowingTemplate;

	private final KafkaTemplate<String, Long> kafkaTemplate;

	@Override
	public Mono<Void> onCopyBorrowed(Borrowing borrowing) {
		var dto = mapper.toDTO(borrowing);
		var fut = borrowingTemplate.send("bookcopies.borrow", dto);
		return Mono.fromFuture(fut).then();
	}

	@Override
	public Mono<Void> onCopyReturned(Borrowing borrowing) {
		var fut = kafkaTemplate.send("bookcopies.return", borrowing.bookCopyId());
		return Mono.fromFuture(fut).then();
	}

}
