package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Book.Entity.UsedBook;

import java.util.ArrayList;
import java.util.List;

// 판매내역
public class SelllistActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SellAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell_list);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager1);
        adapter = new SellAdapter();


        List<UsedBook> books = new ArrayList<>();
        for(UsedBook book : books)
        {
            this.adapter.addItem(book);
        }

        recyclerView.setAdapter(adapter);
    }
}
