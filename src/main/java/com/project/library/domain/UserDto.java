package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserDto {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate accountCreationDate;
}
