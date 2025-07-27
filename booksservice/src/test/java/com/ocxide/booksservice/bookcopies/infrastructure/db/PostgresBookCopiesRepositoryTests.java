package com.ocxide.booksservice.bookcopies.infrastructure.db;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.util.Pair;
import org.springframework.test.context.ActiveProfiles;

import com.ocxide.booksservice.bookcopies.domain.BookCopy;
import com.ocxide.booksservice.bookcopies.domain.CopyStatus;
import com.ocxide.booksservice.bookeditions.domain.BookEdition;
import com.ocxide.booksservice.bookeditions.infrastructure.db.PostgresBookEditionsRepository;
import com.ocxide.booksservice.shared.infrastructure.db.PostgresRepositoryTestImports;

import reactor.test.StepVerifier;

@DataR2dbcTest
@Import(PostgresRepositoryTestImports.class)
@ActiveProfiles("dev")
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
			return repository.createOne(copy).then();
		})).verifyComplete();
	}

	@Test
	void shouldUpdateBookCopy() {
		var edition = new BookEdition("title", "author", "978-0-30-640615-8");
		var copyData = new BookCopy(1L, CopyStatus.Available, Instant.now());

		StepVerifier.create(editionRepository.createOne(edition).flatMap(id -> {
				var copy = new BookCopy(id, copyData.status(), copyData.ingressedAt());
				return repository.createOne(copy).map(copyId -> Pair.of(copyId, copy));
			}).flatMap(pair -> {
				var copy = new BookCopy(pair.getSecond().bookEditionId(), CopyStatus.Borrowed, Instant.now());
				return repository.updateOne(pair.getFirst(), copy);
			}).then()
		).verifyComplete();
	}
}
