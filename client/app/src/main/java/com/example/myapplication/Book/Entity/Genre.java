package com.example.myapplication.Book.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class Genre extends BaseEntity{
    String name;

    Integer depth = 0;

    private Genre parentGenre;

    private List<Genre> childrenGenres = new ArrayList<>();

    private List<BookGenre> bookGenres = new ArrayList<>();
}
