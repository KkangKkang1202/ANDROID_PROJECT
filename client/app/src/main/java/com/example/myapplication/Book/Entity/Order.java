package com.example.myapplication.Book.Entity;


import com.example.myapplication.Book.Entity.Enum.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order extends BaseEntity{
    UsedBook usedBook;

    User consumer;
        OrderStatus status;
}
