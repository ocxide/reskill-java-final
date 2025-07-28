package com.ocxide.booksservice.bookcopies.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ocxide.booksservice.bookcopies.application.OnBorrowOneUseCase;
import com.ocxide.booksservice.bookcopies.application.CreateOneUseCase;
import com.ocxide.booksservice.bookcopies.application.GetOneUseCase;
import com.ocxide.booksservice.bookcopies.application.OnOneReturnedUseCase;
import com.ocxide.booksservice.bookcopies.domain.BookCopiesRepository;

@Configuration
public class BookCopiesBeans {

	@Bean
	CreateOneUseCase createCopyUseCase(BookCopiesRepository repository) {
		return new CreateOneUseCase(repository);
	}

	@Bean
	GetOneUseCase getCopyUseCase(BookCopiesRepository repository) {
		return new GetOneUseCase(repository);
	}

	@Bean
	OnBorrowOneUseCase borrowCopyUseCase(BookCopiesRepository repository) {
		return new OnBorrowOneUseCase(repository);
	}

	@Bean
	OnOneReturnedUseCase onCopyReturnedUseCase(BookCopiesRepository repository) {
		return new OnOneReturnedUseCase(repository);
	}
}
