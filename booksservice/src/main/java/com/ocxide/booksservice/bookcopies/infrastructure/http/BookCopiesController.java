package com.ocxide.booksservice.bookcopies.infrastructure.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ocxide.booksservice.bookcopies.application.CreateOneUseCase;
import com.ocxide.booksservice.bookcopies.application.GetOneUseCase;
import com.ocxide.booksservice.bookcopies.application.ListPerEditionUseCase;
import com.ocxide.booksservice.bookcopies.infrastructure.BookCopiesMapper;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/bookcopies")
@AllArgsConstructor
@OpenAPIDefinition(info = @Info(title = "BookCopiesController", version = "1.0", description = "Operations over book copies"))
public class BookCopiesController {
	private final CreateOneUseCase createOneUseCase;
	private final GetOneUseCase getOneUseCase;
	private final ListPerEditionUseCase listPerEditionUseCase;
	private final BookCopiesMapper mapper;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Long> createOne(@RequestBody @Valid CreateBookCopyDTO dto) {
		var copy = mapper.toDomain(dto);
		return createOneUseCase.run(copy);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<GetOneBookCopyDTO> getOne(@PathVariable @NotNull Long id) {
		return getOneUseCase.run(id)
				.map(mapper::toDto);
	}

	@GetMapping("/editions/{bookEditionId}")
	@Operation(summary = "List book copies per edition")
	@ResponseStatus(HttpStatus.OK)
	public Flux<GetOneBookCopyDTO> listPerEdition(@PathVariable @NotNull Long bookEditionId) {
		return listPerEditionUseCase.run(bookEditionId)
				.map(mapper::toDto);
	}
}
