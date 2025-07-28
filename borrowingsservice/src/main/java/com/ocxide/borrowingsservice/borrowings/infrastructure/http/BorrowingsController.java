package com.ocxide.borrowingsservice.borrowings.infrastructure.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocxide.borrowingsservice.application.CreateOneUseCase;
import com.ocxide.borrowingsservice.application.ListPerUserUseCase;
import com.ocxide.borrowingsservice.application.ReturnCopyUseCase;
import com.ocxide.borrowingsservice.borrowings.infrastructure.BorrowingsMapper;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/borrowings")
@AllArgsConstructor
public class BorrowingsController {
	private final CreateOneUseCase createOne;
	private final ListPerUserUseCase listPerUser;
	private final ReturnCopyUseCase returnCopy;
	private final BorrowingsMapper mapper;

	@PostMapping("/")
	public Mono<Void> createOne(@RequestBody @Valid CreateBorrowingDTO body) {
		var borrowing = mapper.toDomain(body);
		return createOne.createOne(borrowing);
	}

	@GetMapping("/user/{userId}")
	public Flux<ItemBorrowingDTO> getBorrowingsByUserId(@PathVariable @NotNull Long userId) {
		return listPerUser.listPerUser(userId).map(mapper::domainToDTO);
	}

	@PatchMapping("/{id}/return")
	public Mono<Void> returnOne(@PathVariable @NotNull Long id) {
		return returnCopy.run(id);
	}
}
