package com.example.myapplication.Book.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;














































                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                AAAAimport javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsedBook extends BaseEntity{
    private Book book;

    private UserInfo seller;

    private Long usedBookCost;

    private Boolean underline;

    private Boolean penUnderline;

    private Boolean note;

    private Boolean penNote;

    private Boolean bookCoverStatus;

    private Boolean pageStatus;
    private List<UsedBookChatRoom> orderChatRooms = new ArrayList<>();

    private List<Order> orders = new ArrayList<>();

    private List<UsedBookPicture> files = new ArrayList<>();


    public Long getDiscount(){return this.book.getCost() - usedBookCost;}
    public Double getDiscountRate(){return 100.0 - this.getDiscount()*100.0/this.book.getCost();}


}
