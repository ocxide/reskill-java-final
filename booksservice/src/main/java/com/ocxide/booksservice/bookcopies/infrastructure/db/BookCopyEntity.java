package com.ocxide.booksservice.bookcopies.infrastructure.db;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table("book_copies")
@AllArgsConstructor
@Getter
@Setter
public class BookCopyEntity {

	@Id
	private Long id;

	private Long bookEditionId;
	private String status;
	private Instant ingressedAt;
}
