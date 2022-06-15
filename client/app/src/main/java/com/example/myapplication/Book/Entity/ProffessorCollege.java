package com.example.myapplication.Book.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Entity
public class ProffessorCollege extends BaseEntity{
    @ManyToOne
    @JoinColumn
    private Proffesor proffesor;

    @ManyToOne
    @JoinColumn
    private College college;
}
