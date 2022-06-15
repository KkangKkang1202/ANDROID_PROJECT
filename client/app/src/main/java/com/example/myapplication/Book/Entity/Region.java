package com.example.myapplication.Book.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Region extends BaseEntity{
    String name;

    Integer depth;

    private Region parentRegion;

    private List<Region> childrenRegions = new ArrayList<>();

    private List<UserInfo> residents = new ArrayList<>();
}
