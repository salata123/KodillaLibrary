package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentalDto {
    private int id;
    private int bookId;
    private int userId;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
