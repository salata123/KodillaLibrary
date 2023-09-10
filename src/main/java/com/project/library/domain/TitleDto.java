package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TitleDto {
    private int id;
    private String name;
    private String author;
    private LocalDate releaseDate;
}
