package com.ocxide.borrowingsservice.borrowings.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.ocxide.borrowingsservice.application.CreateOneUseCase;
import com.ocxide.borrowingsservice.domain.BookCopiesRepository;
import com.ocxide.borrowingsservice.domain.BorrowingsNotificator;
import com.ocxide.borrowingsservice.domain.BorrowingsRepository;

@Configuration
public class BorrowingBeans {
	@Bean("booksservice")
	WebClient webClient(WebClient.Builder builder, @Value("${booksservice.uri}") String uri) {
		return builder.defaultHeader("Content-Type", "application/json").baseUrl(uri).build();
	}

	@Bean
	CreateOneUseCase createOneUseCase(
			BookCopiesRepository bookCopiesRepository,
			BorrowingsRepository borrowingsRepository,
			BorrowingsNotificator notificator) {
		return new CreateOneUseCase(bookCopiesRepository, borrowingsRepository, notificator);
	}
}
