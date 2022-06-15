package com.example.myapplication.Book.Entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity{
    private String name;

    private Long cost;

    private Author author;

    private Publisher publisher;

    private LocalDateTime publishedDate;

    private List<BookGenre> genres = new ArrayList<>();

    private Book revisedBook;

    private List<Book> otherVersionBooks = new ArrayList<>();

    private List<CollegeBook> colleges = new ArrayList<>();
    private List<LectureBook> lectures = new ArrayList<>();
    private List<MajorBook> majors = new ArrayList<>();

    private List<MajorCollegeBook> majorColleges = new ArrayList<>();
}
