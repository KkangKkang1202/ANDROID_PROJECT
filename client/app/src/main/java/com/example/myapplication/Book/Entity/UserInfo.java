package com.example.myapplication.Book.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserInfo extends BaseEntity{
    User user;

    String nickname;

    String name;

    private College college;

    private Double reputationScore;

    private Region region;

}
