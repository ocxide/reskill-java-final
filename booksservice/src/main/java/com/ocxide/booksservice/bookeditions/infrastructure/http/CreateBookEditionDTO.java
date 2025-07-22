package com.ocxide.booksservice.bookeditions.infrastructure.http;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateBookEditionDTO(
		@NotBlank String title,
		@NotBlank String author,
		@NotNull @Valid ISBNDto isbn) {
}
