package com.ocxide.notificationsservice.notifications.infrastructure.filesystem;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ocxide.notificationsservice.notifications.domain.BookCopyBorrowed;
import com.ocxide.notificationsservice.notifications.domain.BookCopyNearExpiration;
import com.ocxide.notificationsservice.notifications.domain.BookCopyReturned;
import com.ocxide.notificationsservice.notifications.domain.Notificator;

import reactor.core.publisher.Mono;

@Component
public class FileNotificator implements Notificator, AutoCloseable {
	private final FileWriter file;

	public FileNotificator(
			@Value("${notifications.file}") String path) throws IOException {
		this.file = new FileWriter(path, true);
	}

	public Mono<Void> append(Object object) {
		var buf = (Instant.now().toString() + ": " + object.toString() + "\n");

		return Mono.fromCallable(() -> {
			this.file.write(buf);
			this.file.flush();
			return 1;
		}).then();
	}

	@Override
	public Mono<Void> onBorrowed(BookCopyBorrowed borrowing) {
		return this.append(borrowing);
	}

	@Override
	public Mono<Void> onReturned(BookCopyReturned borrowing) {
		return this.append(borrowing);
	}

	@Override
	public Mono<Void> onNearExpiration(BookCopyNearExpiration borrowing) {
		return this.append(borrowing);
	}

	@Override
	public void close() throws Exception {
		this.file.close();
	}

}
