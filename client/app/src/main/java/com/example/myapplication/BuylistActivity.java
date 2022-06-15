package com.example.myapplication;

import static com.navercorp.volleyextensions.volleyer.Volleyer.volleyer;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.example.myapplication.Book.Entity.UsedBook;
import com.example.myapplication.utils.Properties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navercorp.volleyextensions.volleyer.factory.DefaultRequestQueueFactory;

import java.util.ArrayList;
import java.util.List;

// 구매내역
public class BuylistActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    BuyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        ObjectMapper objectMapper = new ObjectMapper();
        RequestQueue queue;
        queue = DefaultRequestQueueFactory.create(this);
        volleyer(queue).settings().setAsDefault().done();
        Button ShowLocationButton = (Button) findViewById(R.id.button);
        queue.start();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_list);
        volleyer().get(Properties.serverUrl+"/");
        recyclerView = findViewById(R.id.buy_list_recyclerView);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager1);
        adapter = new BuyAdapter();

        List<UsedBook> books = new ArrayList<>();
        for(UsedBook book : books)
        {
            this.adapter.addItem(book);
        }


        recyclerView.setAdapter(adapter);
    }
}
