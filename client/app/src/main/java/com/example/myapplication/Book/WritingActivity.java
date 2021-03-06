package com.example.myapplication.Book;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BarActivity;
import com.example.myapplication.Book.Dto.BookCreateDto;
import com.example.myapplication.Book.Dto.LectureCreateDto;
import com.example.myapplication.Book.Dto.UsedBookCreateDto;
import com.example.myapplication.R;
import com.example.myapplication.User.Dto.UserInfoCreateDto;
import com.example.myapplication.User.SignActivity;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WritingActivity extends AppCompatActivity
{
    private static final int REQUEST_CODE = 0;
    private int imageNumber = 0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                try
                {
                    InputStream inputStream = getContentResolver().openInputStream(data.getData());
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();

                    switch (imageNumber)
                    {
                        case 1:
                            bookStateImage1.setImageBitmap(image);
                            break;

                        case 2:
                            bookStateImage2.setImageBitmap(image);
                            break;

                        case 3:
                            bookStateImage3.setImageBitmap(image);
                            break;

                        default:
                            break;
                    }
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
            else if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "?????? ????????? ??????????????????.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    ImageView bookStateImage1;
    ImageView bookStateImage2;
    ImageView bookStateImage3;

    Button WriteButton;
    EditText BookPriceMemo, BookTitleMemo,BookAuthorMemo,BookPublishingDateMemo,ProfessorMemo,CourseMemo
            ,BookStateMemo, BookPriceInput,SchoolCollegeMemo,SchoolNameMemo,SchoolMajorMemo;
    CheckBox underLineCheck, penUnderlineCheck, note,penNote,bookCoverStatus,pageStatus;
    @Override
    @SuppressWarnings("deprecation")
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writing);
        WriteButton= (Button) findViewById(R.id.WriteButton); // ???????????? ??????
        BookPriceMemo= (EditText) findViewById(R.id.BookPublishingDateMemo); // ??????
        BookTitleMemo= (EditText) findViewById(R.id.BookTitleMemo); // ?????????
        BookAuthorMemo= (EditText) findViewById(R.id.BookAuthorMemo); // ??????
        SchoolCollegeMemo=(EditText) findViewById(R.id.SchoolCollegeMemo);// ?????????
        SchoolNameMemo=(EditText) findViewById(R.id.SchoolNameMemo);// ??????
        SchoolMajorMemo=(EditText) findViewById(R.id.SchoolMajorMemo);
        BookPublishingDateMemo=(EditText) findViewById(R.id.BookPublishingDateMemo); // ????????????
        ProfessorMemo=(EditText) findViewById(R.id.ProfessorMemo); // ??????
        CourseMemo=(EditText) findViewById(R.id.CourseMemo); // ?????????
        BookStateMemo=(EditText) findViewById(R.id.BookStateMemo); // ??? ??????
        BookPriceInput = findViewById(R.id.BookPriceInput); // ?????? ??? ??????

        underLineCheck=findViewById(R.id.UnderlineCheck);
        penUnderlineCheck=findViewById(R.id.PenUnderlineCheck);
        note=findViewById(R.id.NoteCheck);
        penNote=findViewById(R.id.PenNoteCheck);
        bookCoverStatus=findViewById(R.id.BookCoverStatusCheck);
        pageStatus=findViewById(R.id.PageStatusCheck);


        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        this.bookStateImage1 = findViewById(R.id.BookStateImage1);
        this.bookStateImage2 = findViewById(R.id.BookStateImage2);
        this.bookStateImage3 = findViewById(R.id.BookStateImage3);

        this.bookStateImage1.setOnClickListener(view ->
        {
            this.imageNumber = 1;
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, REQUEST_CODE);
        });

        this.bookStateImage2.setOnClickListener(view ->
        {
            this.imageNumber = 2;
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, REQUEST_CODE);
        });

        this.bookStateImage3.setOnClickListener(view ->
        {
            this.imageNumber = 3;
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, REQUEST_CODE);
        });

        // ???????????? ?????? ?????????
        WriteButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                try
                {
                    // ???????????? ?????? ?????????, ????????? DB??? ??????????????? ?????????????????? ??????
                    UsedBookCreateDto usedBookCreateDto=new UsedBookCreateDto();
                    System.out.println(BookTitleMemo.getText());
                    usedBookCreateDto.getBook().setName(String.valueOf(BookTitleMemo.getText())); // ?????????
                    usedBookCreateDto.getBook().setCost(Long.valueOf((String.valueOf(BookPriceMemo.getText()))));// ??????_??????
                    usedBookCreateDto.getBook().getLecture().setName(String.valueOf(CourseMemo.getText()));// ?????????
                    usedBookCreateDto.getBook().getProfessor().setName(String.valueOf(ProfessorMemo.getText()));// ?????????
                    usedBookCreateDto.getBook().setPublishedDate(dateFormat.parse(String.valueOf(BookPublishingDateMemo.getText())));// ????????????
                    //??????
                    usedBookCreateDto.getBook().getLecture().getMajorCreateDto().getMajorCollegeCreateDto().getCollegeCreateDto().setName(String.valueOf(SchoolNameMemo.getText()));
                    // ?????????
                    usedBookCreateDto.getBook().getLecture().getMajorCreateDto().getMajorCollegeCreateDto().setName(String.valueOf(SchoolCollegeMemo.getText()));
                    // ??????
                    usedBookCreateDto.getBook().getLecture().getMajorCreateDto().setName(String.valueOf(SchoolMajorMemo.getText()));
                    // ?????????
                    usedBookCreateDto.setUsedBookCost(Long.valueOf((String.valueOf(BookPriceInput.getText()))));
                    // ????????? ??????
                    usedBookCreateDto.setContent(String.valueOf(BookStateMemo.getText()));
                    // ????????????(6???)

                    usedBookCreateDto.setUnderline(underLineCheck.isChecked());
                    usedBookCreateDto.setPenUnderline(penUnderlineCheck.isChecked());
                    usedBookCreateDto.setNote(note.isChecked());
                    usedBookCreateDto.setPenNote(penNote.isChecked());
                    usedBookCreateDto.setBookCoverStatus(bookCoverStatus.isChecked());
                    usedBookCreateDto.setPageStatus(pageStatus.isChecked());


                    Intent intent = new Intent(getApplicationContext(), BarActivity.class);
                    startActivity(intent);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    Toast.makeText(getApplicationContext(), "?????? ????????? ??????????????????.", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
