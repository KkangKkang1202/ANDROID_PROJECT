package com.example.myapplication.User.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
    @Getter
    String accessToken;

    public String getAccessToken() {
        return accessToken;
    }
}
