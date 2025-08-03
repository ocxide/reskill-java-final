package com.ocxide.notificationsservice.notifications.infrastructure.filesystem;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ocxide.notificationsservice.notifications.domain.BookCopyBorrowed;
import com.ocxide.notificationsservice.notifications.domain.BookCopyNearExpiration;
import com.ocxide.notificationsservice.notifications.domain.BookCopyReturned;
import com.ocxide.notificationsservice.notifications.domain.Notificator;

import reactor.core.publisher.Mono;

@Component
public class FileNotificator implements Notificator {
	private final AsynchronousFileChannel file;

	public FileNotificator(
			@Value("${notifications.file}") String path) throws IOException {
		var filepath = Paths.get(path);

		this.file = AsynchronousFileChannel.open(filepath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
	}

	private Mono<FileLock> lock() {
		var lockFut = new CompletableFuture<FileLock>();

		file.lock(lockFut, new CompletionHandler<FileLock, CompletableFuture<FileLock>>() {

			@Override
			public void completed(FileLock result, CompletableFuture<FileLock> attachment) {
				attachment.complete(result);
			}

			@Override
			public void failed(Throwable exc, CompletableFuture<FileLock> attachment) {
				attachment.completeExceptionally(exc);
			}

		});

		return Mono.fromFuture(lockFut);
	}

	public Mono<Void> append(Object object) {
		var buf = ByteBuffer.wrap((Instant.now().toString() + ": " + object.toString() + "\n").getBytes());
		return this.lock().handle((lock, sink) -> {
			try (lock) {
				lock.channel().write(buf);
				sink.next(1);
				sink.complete();
			} catch (IOException e) {
				sink.error(e);
			}
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

}
