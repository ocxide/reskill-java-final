package com.ocxide.borrowingsservice.borrowings.infrastructure.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocxide.borrowingsservice.application.CreateOneUseCase;
import com.ocxide.borrowingsservice.borrowings.infrastructure.BorrowingsMapper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/borrowings")
@AllArgsConstructor
public class BorrowingsController {
	private final CreateOneUseCase createOne;
	private final BorrowingsMapper mapper;

	@PostMapping("/")
	public Mono<Void> createOne(@RequestBody @Valid CreateBorrowingDTO body) {
		var borrowing = mapper.toDomain(body);
		return createOne.createOne(borrowing);
	}
}
