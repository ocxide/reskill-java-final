package com.ocxide.borrowingsservice;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ocxide.borrowingsservice.shared.infrastructure.IntegrationTest;

@SpringBootTest
@Tag(IntegrationTest.TAG)
class BorrowingsserviceApplicationTests {

	@Test
	void contextLoads() {
	}

}
