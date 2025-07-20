package com.ocxide.usersservice.infrastructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ocxide.usersservice.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	public User fromDto(CreateUserDTO user);

	@Mapping(target = "id", ignore = true)
	public UserEntity toEntity(User user);
}
