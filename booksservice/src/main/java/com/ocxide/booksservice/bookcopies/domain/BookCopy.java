package com.ocxide.booksservice.bookcopies.domain;

import java.time.Instant;

public record BookCopy(
		Long bookEditionId,
		CopyStatus status,
		Instant ingressedAt) {
}
