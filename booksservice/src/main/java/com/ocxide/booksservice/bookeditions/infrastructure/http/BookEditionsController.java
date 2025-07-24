package com.ocxide.booksservice.bookeditions.infrastructure.http;

import org.springframework.web.bind.annotation.RestController;

import com.ocxide.booksservice.bookeditions.application.CreateOneUseCase;
import com.ocxide.booksservice.bookeditions.infrastructure.BookEditionsMapper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("bookeditions")
@AllArgsConstructor
public class BookEditionsController {
	private final BookEditionsMapper mapper;
	private final CreateOneUseCase createOneUseCase;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Void> createOne(@RequestBody @Valid CreateBookEditionDTO body) {
		var edition = mapper.toDomain(body);
		return createOneUseCase.run(edition).then();
	}

}
