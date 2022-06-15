package com.example.myapplication.Book.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chat extends BaseEntity{
    @OneToOne
    @JoinColumn
    private Content content;

    @ManyToOne
    @JoinColumn
    private ChatRoom room;

    @ManyToOne
    @JoinColumn
    private UserInfo writer;
}
