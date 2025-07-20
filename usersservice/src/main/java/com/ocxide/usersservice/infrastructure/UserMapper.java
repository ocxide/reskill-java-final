package com.ocxide.usersservice.infrastructure;

import org.mapstruct.Mapper;

import com.ocxide.usersservice.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	public User fromDto(CreateUserDTO user);
}
