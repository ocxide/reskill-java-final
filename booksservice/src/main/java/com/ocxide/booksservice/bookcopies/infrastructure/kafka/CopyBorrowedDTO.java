package com.ocxide.booksservice.bookcopies.infrastructure.kafka;

import java.time.Duration;
import java.time.Instant;

public record CopyBorrowedDTO(
		Long bookCopyId,
		Duration expiresPast,
		Instant borrowedAt) {
}
