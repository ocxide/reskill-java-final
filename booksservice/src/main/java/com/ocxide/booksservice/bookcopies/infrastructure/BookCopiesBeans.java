package com.ocxide.booksservice.bookcopies.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ocxide.booksservice.bookcopies.application.CreateOneUseCase;
import com.ocxide.booksservice.bookcopies.domain.BookCopiesRepository;

@Configuration
public class BookCopiesBeans {

	@Bean
	CreateOneUseCase createOneUseCase(BookCopiesRepository repository) {
		return new CreateOneUseCase(repository);
	}
}
