package com.ocxide.booksservice.bookcopies.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ocxide.booksservice.bookcopies.application.OnBorrowOneUseCase;
import com.ocxide.booksservice.bookcopies.application.OnOneReturnedUseCase;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KafkaBorrowBookListener {
	private final OnBorrowOneUseCase borrowOneUseCase;
	private final OnOneReturnedUseCase onOneReturnedUseCase;

	@KafkaListener(topics = "bookcopies.borrow")
	public void listen(CopyBorrowedDTO content) {
		var id = content.bookCopyId();
		borrowOneUseCase.run(id).subscribe(v -> {
		}, error -> {
			System.out.println("An error ocurred while marking a book as borrowed: " + error);
		});
	}

	@KafkaListener(topics = "bookcopies.return")
	public void listenReturn(Long id) {
		onOneReturnedUseCase.run(id).subscribe(v -> {
		}, error -> {
			System.out.println("An error ocurred while marking a book as returned: " + error);
		});
	}
}
