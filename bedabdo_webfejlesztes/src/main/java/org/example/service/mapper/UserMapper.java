package org.example.service.mapper;

import org.example.dto.UserRegistrationDto;
import org.example.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User userRegistrationDtoToUser(UserRegistrationDto userRegistrationDto);

    List<User> userRegistrationDtoListToUserList(List<UserRegistrationDto> userRegistrationDtos);

    @Mapping(target = "password", ignore = true)
    UserRegistrationDto userToUserRegistrationDto(User user);

    List<UserRegistrationDto> userListToUserRegistrationDtoList(List<User> users);
}
