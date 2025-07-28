package com.ocxide.borrowingsservice.borrowings.domain;

import java.time.Duration;
import java.time.Instant;

public record Borrowing(
		Long id,
		Long userId,
		Long bookCopyId,
		Duration expiresPast,
		Instant borrowedAt) {
}
