package com.ocxide.notificationsservice.notifications.infrastructure.kafka;

import java.time.Duration;
import java.time.Instant;

public record BookCopyBorrowedEvent(
		Long id,
		Long userId,
		Long bookCopyId,
		Duration expiresPast,
		Instant borrowedAt) {
}
