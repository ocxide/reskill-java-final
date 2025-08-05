package com.ocxide.borrowingsservice.borrowings.application;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ocxide.borrowingsservice.borrowings.domain.BookCopiesRepository;
import com.ocxide.borrowingsservice.borrowings.domain.BookCopy;
import com.ocxide.borrowingsservice.borrowings.domain.Borrowing;
import com.ocxide.borrowingsservice.borrowings.domain.BorrowingsNotificator;
import com.ocxide.borrowingsservice.borrowings.domain.BorrowingsRepository;
import com.ocxide.borrowingsservice.borrowings.domain.CopyStatus;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class CreateOneUseCaseTests {

	@Mock
	BookCopiesRepository bookCopiesRepository;

	@Mock
	BorrowingsRepository borrowingsRepository;

	@Mock
	BorrowingsNotificator notificator;

	@InjectMocks
	CreateOneUseCase useCase;

	@Test
	public void shouldCreteBorrowing() {
		var borrowing = new Borrowing(1L, 1L, 1L, Duration.ofDays(1), Instant.now());
		var bookCopy = new BookCopy(CopyStatus.Available);

		Mockito.when(bookCopiesRepository.getOne(1L)).thenReturn(Mono.just(Optional.of(bookCopy)));
		Mockito.when(borrowingsRepository.createOne(borrowing)).thenReturn(Mono.just(borrowing));
		Mockito.when(notificator.onCopyBorrowed(borrowing)).thenReturn(Mono.empty());

		StepVerifier.create(useCase.createOne(borrowing))
				.expectNext(borrowing.id())
				.expectComplete()
				.verify();
	}
}
