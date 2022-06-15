package com.example.myapplication.Book.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Picture extends BaseEntity{
    private String fileName;

    private String fileOriName;
    private String fileUrl;

    private Long fileSize;
    private ContentPicture contentFile;

    private UsedBookPicture usedBookPicture;
}
