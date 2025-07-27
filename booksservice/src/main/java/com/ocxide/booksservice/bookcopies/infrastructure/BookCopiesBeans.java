package com.ocxide.booksservice.bookcopies.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ocxide.booksservice.bookcopies.application.BorrowOneUseCase;
import com.ocxide.booksservice.bookcopies.application.CreateOneUseCase;
import com.ocxide.booksservice.bookcopies.application.GetOneUseCase;
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
	BorrowOneUseCase borrowCopyUseCase(BookCopiesRepository repository) {
		return new BorrowOneUseCase(repository);
	}
}
