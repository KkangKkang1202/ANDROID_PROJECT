package com.example.myapplication.Book.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class College extends BaseEntity{
    String name;

    @JsonManagedReference
    private List<MajorCollege> majorColleges = new ArrayList<>();

    private List<Major> majors = new ArrayList<>();

    private List<Lecture> lectures = new ArrayList<>();
    private List<UserInfo> students = new ArrayList<>();

}
