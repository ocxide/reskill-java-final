package com.ocxide.booksservice.bookcopies.infrastructure.http;

import java.time.Instant;

import com.ocxide.booksservice.bookcopies.domain.CopyStatus;

import jakarta.validation.constraints.NotNull;

public record GetOneBookCopyDTO(@NotNull Long id,
		@NotNull Long bookEditionId,
		@NotNull Instant ingressedAt,
		@NotNull CopyStatus status) {
}
