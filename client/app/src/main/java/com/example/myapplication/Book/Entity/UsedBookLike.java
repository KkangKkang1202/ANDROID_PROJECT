package com.example.myapplication.Book.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsedBookLike extends BaseEntity{
    @ManyToOne
    @JoinColumn
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn
    private UsedBook usedBook;
}
