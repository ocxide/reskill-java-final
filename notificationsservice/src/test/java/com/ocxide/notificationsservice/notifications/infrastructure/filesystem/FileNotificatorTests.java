package com.ocxide.notificationsservice.notifications.infrastructure.filesystem;

import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import com.ocxide.notificationsservice.notifications.domain.BookCopyBorrowed;
import com.ocxide.notificationsservice.notifications.domain.Borrowing;

import reactor.test.StepVerifier;

@SpringBootTest(classes = { FileNotificator.class })
@Profile("dev")
public class FileNotificatorTests {

	@Autowired
	private FileNotificator notificator;

	@Test
	public void shouldWriteToFile() {
		var borrowing = new Borrowing(1L, 1L, 1L, Duration.ofHours(1), Instant.now(), false);
		var write = notificator.onBorrowed(new BookCopyBorrowed(borrowing));

		StepVerifier.create(write).verifyComplete();
	}
}
