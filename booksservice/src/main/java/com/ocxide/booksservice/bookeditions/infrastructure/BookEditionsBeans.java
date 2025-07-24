package com.ocxide.booksservice.bookeditions.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ocxide.booksservice.bookeditions.application.CreateOneUseCase;
import com.ocxide.booksservice.bookeditions.domain.BookEditionsRepository;

@Configuration
public class BookEditionsBeans {
	@Bean
	CreateOneUseCase createEditionUseCase(BookEditionsRepository repository) {
		return new CreateOneUseCase(repository);
	}

}
