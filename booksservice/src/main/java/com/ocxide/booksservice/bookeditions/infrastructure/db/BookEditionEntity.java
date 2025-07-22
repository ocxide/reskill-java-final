package com.ocxide.booksservice.bookeditions.infrastructure.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("book_editions")
@Getter
@Setter
public class BookEditionEntity {
	@Id
	private Long id;
	private String title;
	private String author;
	private String isbn;
}
