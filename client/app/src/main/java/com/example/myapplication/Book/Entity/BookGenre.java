package com.example.myapplication.Book.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;


@Getter
public class BookGenre extends BaseEntity{
    private Book book;

    private Genre genre;
}
