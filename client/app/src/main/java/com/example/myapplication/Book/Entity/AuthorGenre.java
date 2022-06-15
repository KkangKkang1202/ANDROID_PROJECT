package com.example.myapplication.Book.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;


@Getter
public class AuthorGenre extends BaseEntity{
    private Author author;
    private Genre genre;
}
