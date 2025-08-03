package com.ocxide.borrowingsservice.borrowings.infrastructure.kafka;

import java.time.Duration;
import java.time.Instant;

public record CopyBorrowedDTO(
		Long id,
		Long userId,
		Long bookCopyId,
		Duration expiresPast,
		Instant borrowedAt) {
}
