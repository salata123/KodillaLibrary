package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class BookCopyDto {
    private int id;
    private int titleId;
    private String status;
}
