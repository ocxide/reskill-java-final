package com.ocxide.notificationsservice.notifications.infrastructure;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ocxide.notificationsservice.notifications.application.BorrowingsNearExpirationUseCase;
import com.ocxide.notificationsservice.notifications.application.OnBookCopyBorrowedUseCase;
import com.ocxide.notificationsservice.notifications.application.OnBookCopyReturnedUseCase;
import com.ocxide.notificationsservice.notifications.domain.BorrowingsRepository;
import com.ocxide.notificationsservice.notifications.domain.Notificator;

@Configuration
public class NotificationsBeans {

	@Bean
	OnBookCopyBorrowedUseCase onBookCopyBorrowedUseCase(BorrowingsRepository repository, Notificator notificator) {
		return new OnBookCopyBorrowedUseCase(repository, notificator);
	}

	@Bean
	OnBookCopyReturnedUseCase onBookCopyReturnedUseCase(BorrowingsRepository repository, Notificator notificator) {
		return new OnBookCopyReturnedUseCase(repository, notificator);
	}

	@Bean
	BorrowingsNearExpirationUseCase borrowingsExpiringUseCase(
			@Value("${notifications.threshold}") Duration threshold,
			BorrowingsRepository repository, Notificator notificator) {
		return new BorrowingsNearExpirationUseCase(threshold, repository, notificator);
	}
}
