package com.ocxide.usersservice.users.infrastructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ocxide.usersservice.users.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	public User fromDto(CreateUserDTO user);

	@Mapping(target = "id", ignore = true)
	public UserEntity toEntity(User user);
}
