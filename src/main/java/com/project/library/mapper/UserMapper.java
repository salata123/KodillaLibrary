package com.project.library.mapper;

import com.project.library.domain.BookCopy;
import com.project.library.domain.BookCopyDto;
import com.project.library.domain.User;
import com.project.library.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getAccountCreationDate()
        );
    }

    public UserDto mapToUserDto(final User user){
        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getAccountCreationDate()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> usersList){
        return usersList.stream()
                .map(this::mapToUserDto)
                .toList();
    }
}
