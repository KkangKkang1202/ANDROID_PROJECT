package com.example.myapplication.Book.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    private String phone;

    private List<UserRole> roles = new ArrayList<>();

    private List<UsedBook> usedBooks = new ArrayList<>();

    private List<ChatRoomParticipant> participatedChatRooms = new ArrayList<>();

    private List<ChatRoom> ownChatRooms = new ArrayList<>();

}
