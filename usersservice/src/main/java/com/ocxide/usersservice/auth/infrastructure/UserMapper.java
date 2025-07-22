package com.ocxide.usersservice.auth.infrastructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ocxide.usersservice.auth.infrastructure.db.UserEntity;
import com.ocxide.usersservice.auth.infrastructure.http.CreateUserDTO;
import com.ocxide.usersservice.auth.domain.AuthUser;
import com.ocxide.usersservice.auth.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	public User fromDto(CreateUserDTO user);

	@Mapping(target = "id", ignore = true)
	public UserEntity toEntity(User user);

	AuthUser toAuthUser(UserEntity user);
}
