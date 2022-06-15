package com.example.myapplication.Book.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
