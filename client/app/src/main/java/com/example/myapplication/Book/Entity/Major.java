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

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Major extends BaseEntity{
    private String name;

    private MajorCollege majorCollege;

    private College college;
    @OneToMany(mappedBy = "major", fetch = FetchType.LAZY)
    private List<MajorBook> books = new ArrayList<>();

}
