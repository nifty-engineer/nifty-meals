package com.niftyengineer.niftymeals.mapper;

import com.niftyengineer.niftymeals.dto.SignUpDto;
import com.niftyengineer.niftymeals.dto.UserDto;
import com.niftyengineer.niftymeals.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
