package com.ocxide.notificationsservice.notifications.infrastructure.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ocxide.notificationsservice.notifications.application.BorrowingsNearExpirationUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NearExpireBorrwingsCron {

	private final BorrowingsNearExpirationUseCase useCase;

	@Scheduled(fixedRate = 60000)
	public void run() {
		System.out.println("Scanning near expiration borrowings...");
		useCase.run().subscribe(v -> {}, err -> {
			System.out.println("Failed to scan near expiration borrowings: " + err);
		});
	}
}
