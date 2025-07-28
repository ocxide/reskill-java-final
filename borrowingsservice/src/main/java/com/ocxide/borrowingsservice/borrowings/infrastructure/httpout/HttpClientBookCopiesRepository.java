package com.ocxide.borrowingsservice.borrowings.infrastructure.httpout;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.ocxide.borrowingsservice.borrowings.domain.BookCopiesRepository;
import com.ocxide.borrowingsservice.borrowings.domain.BookCopy;

import reactor.core.publisher.Mono;

@Service
public record HttpClientBookCopiesRepository(@Qualifier("booksservice") WebClient client)
		implements BookCopiesRepository {

	@Override
	public Mono<Optional<BookCopy>> getOne(Long id) {
		return client.get()
				.uri("/bookcopies/" + id)
				.retrieve()
				.bodyToMono(BookCopy.class)
				.map(Optional::ofNullable)
				.onErrorResume(WebClientResponseException.class,
						ex -> ex.getStatusCode().equals(HttpStatus.NOT_FOUND) ? Mono.just(Optional.empty()) : Mono.error(ex));
	}

}
