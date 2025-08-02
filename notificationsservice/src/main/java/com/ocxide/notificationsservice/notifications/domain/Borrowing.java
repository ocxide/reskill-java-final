package com.ocxide.notificationsservice.notifications.domain;

import java.time.Duration;
import java.time.Instant;

public record Borrowing(
		Long id,
		Long userId,
		Long bookCopyId,
		Duration expiresPast,
		Instant borrowedAt) {

	@Override
	public String toString() {
		return String.format("%s BookCopy %s borrowed by user %s at %s for %s", this.id(), this.bookCopyId(), this.userId(),
				this.borrowedAt(), this.expiresPast());
	}
}
