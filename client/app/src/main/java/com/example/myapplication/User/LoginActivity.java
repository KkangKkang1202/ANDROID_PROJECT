package com.example.myapplication.User;

import static com.navercorp.volleyextensions.volleyer.Volleyer.volleyer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.navercorp.volleyextensions.volleyer.factory.DefaultRequestQueueFactory;

public class LoginActivity extends AppCompatActivity {

    Button certi_gps;
    Button shcooladd;
    EditText schoolname;
    EditText starname;
    public static String college;
    public static String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        schoolname=(EditText) findViewById(R.id.schoolname); // 학교명
        certi_gps= (Button) findViewById(R.id.nameadd); // 별명 등록 버튼
        starname=(EditText) findViewById(R.id.starname); // 별명

        certi_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.college = String.valueOf(schoolname.getText());
                LoginActivity.nickname = String.valueOf(starname.getText());
                Intent intent = new Intent(getApplicationContext(), GpsActivity.class);
                startActivity(intent);
            }
        });


    }
}