package com.accionlabs.ecommerce.eazyecommerce.mapper;

import com.accionlabs.ecommerce.eazyecommerce.dto.UserDto;
import com.accionlabs.ecommerce.eazyecommerce.entities.User;

public final class UserMapper {

    private UserMapper() {
    }

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        return user;
    }
}
