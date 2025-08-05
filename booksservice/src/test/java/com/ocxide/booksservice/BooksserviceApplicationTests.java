package com.ocxide.booksservice;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ocxide.booksservice.shared.infrastructure.IntegrationTest;

@SpringBootTest
@Tag(IntegrationTest.TAG)
@ActiveProfiles("dev")
class BooksserviceApplicationTests {

	@Test
	void contextLoads() {
	}

}
