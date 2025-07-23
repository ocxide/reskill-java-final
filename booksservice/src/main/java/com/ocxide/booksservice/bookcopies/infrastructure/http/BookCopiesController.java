package com.ocxide.booksservice.bookcopies.infrastructure.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ocxide.booksservice.bookcopies.application.CreateOneUseCase;
import com.ocxide.booksservice.bookcopies.infrastructure.BookCopiesMapper;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bookcopies")
@AllArgsConstructor
public class BookCopiesController {
	private final CreateOneUseCase createOneUseCase;
	private final BookCopiesMapper mapper;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Void> createOne(@RequestBody CreateBookCopyDTO dto) {
		var copy = mapper.toDomain(dto);
		return createOneUseCase.run(copy);
	}
}
