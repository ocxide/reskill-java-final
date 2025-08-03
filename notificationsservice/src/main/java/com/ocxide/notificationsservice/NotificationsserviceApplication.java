package com.ocxide.notificationsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NotificationsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationsserviceApplication.class, args);
	}

}
