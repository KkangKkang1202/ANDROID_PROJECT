package com.example.myapplication;

import static com.navercorp.volleyextensions.volleyer.Volleyer.volleyer;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.RequestQueue;
import com.example.myapplication.Book.FragmentHome;
import com.example.myapplication.Chat.FragmentChat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.navercorp.volleyextensions.volleyer.factory.DefaultRequestQueueFactory;

public class BarActivity extends AppCompatActivity
{
    LinearLayout home_ly;
    BottomNavigationView bottomNavigationView;
    static public RequestQueue queue;
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        RequestQueue queue;
        queue = DefaultRequestQueueFactory.create(this);
        volleyer(queue).settings().setAsDefault().done();

        queue.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar);
        init();
        SettingListener();
        bottomNavigationView.setSelectedItemId(R.id.Home);

        queue = DefaultRequestQueueFactory.create(this);
    }
    private void init()
    {
        home_ly = findViewById(R.id.home_ly);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }
    private void SettingListener()
    {
        bottomNavigationView.setOnItemSelectedListener(new TabSelectedListener());
    }
    class TabSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener
    {
        @Override public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
        {
            switch (menuItem.getItemId())
            {
                case R.id.Home: {
                    getSupportFragmentManager().beginTransaction() .replace(R.id.home_ly, new FragmentHome()) .commit();
                    return true;
                }
                case R.id.Chat: {
                    getSupportFragmentManager().beginTransaction() .replace(R.id.home_ly, new FragmentChat()) .commit();
                    return true;
                }
                case R.id.My: {
                    getSupportFragmentManager().beginTransaction() .replace(R.id.home_ly, new Fragment_My()) .commit();
                    return true;
                }
            }
            return false;
        }
    }

}
