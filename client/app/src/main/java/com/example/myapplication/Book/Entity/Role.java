package com.example.myapplication.Book.Entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity{
    private String name;

    private String description;

    private List<UserRole> userRoles = new ArrayList<>();
}
