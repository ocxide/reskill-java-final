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
import com.ocxide.booksservice.bookcopies.domain.BookCopyNotFound;
import com.ocxide.booksservice.bookcopies.domain.CopyStatus;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class OnOneReturnedUseCaseTests {

	@Mock
	BookCopiesRepository repository;

	@InjectMocks
	OnOneReturnedUseCase useCase;

	@Test
	public void shouldRejectNonexistentBookCopies() {
		Mockito.when(repository.getOne(1L)).thenReturn(Mono.just(Optional.empty()));

		StepVerifier.create(useCase.run(1L))
				.expectError(BookCopyNotFound.class)
				.verify();
	}

	@Test
	public void shouldUpdateOne() {
		var bookCopy = new BookCopy(1L, null, CopyStatus.Available, null);
		Mockito.when(repository.getOne(1L)).thenReturn(Mono.just(Optional.ofNullable(bookCopy)));
		Mockito.when(repository.updateOne(1L, bookCopy))
				.thenReturn(Mono.empty());

		StepVerifier.create(useCase.run(1L))
				.expectComplete()
				.verify();
	}
}
