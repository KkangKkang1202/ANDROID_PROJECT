package com.example.myapplication.Book.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.*;


@Getter
public class UserRole extends BaseEntity{
    private Role role;

    private User user;
}
