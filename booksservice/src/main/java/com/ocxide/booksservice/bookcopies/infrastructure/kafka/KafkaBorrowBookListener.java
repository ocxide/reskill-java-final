package com.ocxide.booksservice.bookcopies.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ocxide.booksservice.bookcopies.application.BorrowOneUseCase;
import com.ocxide.booksservice.bookcopies.application.OnOneReturnedUseCase;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KafkaBorrowBookListener {
	private final BorrowOneUseCase borrowOneUseCase;
	private final OnOneReturnedUseCase onOneReturnedUseCase;

	@KafkaListener(topics = "bookcopies.borrow")
	public void listen(String content) {
		var id = Long.parseLong(content); 
		borrowOneUseCase.run(id).subscribe(v -> {}, error -> {
			System.out.println("An error ocurred while marking a book as borrowed: " + error);
		});
	}

	@KafkaListener(topics = "bookcopies.return")
	public void listenReturn(String content) {
		var id = Long.parseLong(content); 
		onOneReturnedUseCase.run(id).subscribe(v -> {}, error -> {
			System.out.println("An error ocurred while marking a book as returned: " + error);
		});
	}
}
