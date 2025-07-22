package com.ocxide.booksservice.bookeditions.infrastructure;

import org.springframework.context.annotation.Configuration;

import com.ocxide.booksservice.bookeditions.application.CreateOneUseCase;
import com.ocxide.booksservice.bookeditions.domain.BookEditionsRepository;

@Configuration
public class BookEditionsBeans {
	CreateOneUseCase createOneUseCase(BookEditionsRepository repository) {
		return new CreateOneUseCase(repository);
	}

}
