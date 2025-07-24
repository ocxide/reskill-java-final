package com.ocxide.booksservice.shared.infrastructure.db;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

import com.ocxide.booksservice.bookcopies.infrastructure.BookCopiesMapperImpl;
import com.ocxide.booksservice.bookcopies.infrastructure.db.PostgresBookCopiesRepository;
import com.ocxide.booksservice.bookeditions.infrastructure.BookEditionsMapperImpl;
import com.ocxide.booksservice.bookeditions.infrastructure.ISBNMapperImpl;
import com.ocxide.booksservice.bookeditions.infrastructure.db.PostgresBookEditionsRepository;

@TestConfiguration
@Import({ PostgresBookCopiesRepository.class, PostgresBookEditionsRepository.class, BookCopiesMapperImpl.class,
		BookEditionsMapperImpl.class, ISBNMapperImpl.class })
public class PostgresRepositoryTestImports {

}
