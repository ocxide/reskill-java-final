package com.ocxide.booksservice.bookcopies.infrastructure.http;

import java.time.Instant;
import java.util.Optional;

import jakarta.validation.constraints.NotNull;

public record CreateBookCopyDTO(
		@NotNull Long bookEditionId,
		Optional<Instant> ingressedAt) {
}
