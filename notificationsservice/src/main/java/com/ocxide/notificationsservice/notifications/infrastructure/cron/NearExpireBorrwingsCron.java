package com.ocxide.notificationsservice.notifications.infrastructure.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NearExpireBorrwingsCron {

	@Scheduled(fixedRate = 60000)
	public void run() {

	}
}
