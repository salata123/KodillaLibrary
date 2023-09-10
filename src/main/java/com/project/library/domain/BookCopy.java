package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "book_copies")
public class BookCopy {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "titleId")
    private int titleId;

    @Column(name = "status")
    private String status;
}
