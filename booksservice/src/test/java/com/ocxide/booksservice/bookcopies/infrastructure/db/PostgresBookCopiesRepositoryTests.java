package com.ocxide.booksservice.bookcopies.infrastructure.db;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import com.ocxide.booksservice.bookcopies.domain.BookCopy;
import com.ocxide.booksservice.bookcopies.domain.CopyStatus;
import com.ocxide.booksservice.bookeditions.domain.BookEdition;
import com.ocxide.booksservice.bookeditions.infrastructure.db.PostgresBookEditionsRepository;
import com.ocxide.booksservice.shared.infrastructure.db.PostgresRepositoryTestImports;

import reactor.test.StepVerifier;

@DataR2dbcTest
@Import(PostgresRepositoryTestImports.class)
public class PostgresBookCopiesRepositoryTests {

	@Autowired
	PostgresBookCopiesRepository repository;

	@Autowired
	PostgresBookEditionsRepository editionRepository;

	@Test
	void shouldSaveBookCopy() {
		var edition = new BookEdition("title", "author", "978-0-30-640615-7");
		var copyData = new BookCopy(1L, CopyStatus.Available, Instant.now());

		StepVerifier.create(editionRepository.createOne(edition).flatMap(id -> {
			var copy = new BookCopy(id, copyData.status(), copyData.ingressedAt());
			return repository.createOne(copy);
		})).verifyComplete();
	}
}
