package com.ocxide.booksservice.bookcopies.application;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ocxide.booksservice.bookcopies.domain.BookCopiesRepository;
import com.ocxide.booksservice.bookcopies.domain.BookCopy;
import com.ocxide.booksservice.bookcopies.domain.BookCopyNotAvailable;
import com.ocxide.booksservice.bookcopies.domain.BookCopyNotFound;
import com.ocxide.booksservice.bookcopies.domain.CopyStatus;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class OnBorrowOneUseCaseTests {

	@Mock
	BookCopiesRepository repository;

	@InjectMocks
	OnBorrowOneUseCase useCase;

	@Test
	public void shouldRejectBorrowedBookCopies() {
		var bookCopy = new BookCopy(null, null, CopyStatus.Borrowed, null);
		Mockito.when(repository.getOne(1L)).thenReturn(Mono.just(Optional.ofNullable(bookCopy)));

		StepVerifier.create(useCase.run(1L))
				.expectError(BookCopyNotAvailable.class)
				.verify();
	}

	@Test
	public void shouldRejectNonexistentBookCopies() {
		Mockito.when(repository.getOne(1L)).thenReturn(Mono.just(Optional.empty()));

		StepVerifier.create(useCase.run(1L))
				.expectError(BookCopyNotFound.class)
				.verify();
	}

	@Test
	public void shouldBorrowAvailableBookCopies() {
		var bookCopy = new BookCopy(1L, null, CopyStatus.Available, null);
		var borrowed = new BookCopy(1L, null, CopyStatus.Borrowed, null);

		Mockito.when(repository.getOne(1L)).thenReturn(Mono.just(Optional.ofNullable(bookCopy)));
		Mockito.when(repository.updateOne(1L, borrowed))
				.thenReturn(Mono.empty());

		StepVerifier.create(useCase.run(1L))
				.expectComplete()
				.verify();
	}
}
