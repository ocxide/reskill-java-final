package com.ocxide.booksservice.bookcopies.infrastructure.db;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.ocxide.booksservice.bookcopies.domain.BookCopy;
import com.ocxide.booksservice.bookcopies.domain.CopyStatus;
import com.ocxide.booksservice.bookcopies.infrastructure.BookCopiesMapperImpl;
import com.ocxide.booksservice.bookeditions.domain.BookEdition;
import com.ocxide.booksservice.bookeditions.infrastructure.BookEditionsMapperImpl;
import com.ocxide.booksservice.bookeditions.infrastructure.ISBNMapperImpl;
import com.ocxide.booksservice.bookeditions.infrastructure.db.PostgresBookEditionsRepository;

import reactor.test.StepVerifier;

@DataR2dbcTest
@ActiveProfiles("test")
@Import({ PostgresBookCopiesRepository.class, PostgresBookEditionsRepository.class, BookCopiesMapperImpl.class,
		BookEditionsMapperImpl.class, ISBNMapperImpl.class })
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
