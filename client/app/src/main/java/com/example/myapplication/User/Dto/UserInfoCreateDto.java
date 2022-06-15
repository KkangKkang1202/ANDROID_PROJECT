package com.example.myapplication.User.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class UserInfoCreateDto {
    UserCreateDto user;
    String nickname;
    String college;
    String region;

    public UserInfoCreateDto()
    {
        this.user = new UserCreateDto();
    }


    public UserCreateDto getUser() {
        return user;
    }

    public void setUser(UserCreateDto userCreateDto) {
        this.user = userCreateDto;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
