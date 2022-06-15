package com.example.myapplication.User;

import static com.example.myapplication.utils.Properties.token;
import static com.navercorp.volleyextensions.volleyer.Volleyer.volleyer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.BarActivity;
import com.example.myapplication.Book.FragmentHome;
import com.example.myapplication.R;
import com.example.myapplication.User.Dto.TokenDto;
import com.example.myapplication.User.Dto.TokenResponse;
import com.example.myapplication.User.Dto.UserCreateDto;
import com.example.myapplication.User.Dto.UserOtpDto;
import com.example.myapplication.utils.Properties;
import com.example.myapplication.utils.ResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navercorp.volleyextensions.volleyer.Volleyer;
import com.navercorp.volleyextensions.volleyer.factory.DefaultRequestQueueFactory;
import com.navercorp.volleyextensions.volleyer.response.parser.Jackson2NetworkResponseParser;

import java.io.IOException;

public class SignActivity extends AppCompatActivity {
    EditText inputBunho;
    String phoneValidation = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$";
    RequestQueue queue;
    Button certiButton;
    Button btnBunho;
    EditText inputcertnum;
    ObjectMapper objectMapper = new ObjectMapper();

    public static String phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        UserCreateDto userSignupDto = new UserCreateDto();
        UserOtpDto userOtpDto;
        queue = DefaultRequestQueueFactory.create(this);
        btnBunho = (Button) findViewById(R.id.btnBunho);
        inputcertnum = (EditText) findViewById(R.id.inputcertnum);
        inputBunho = (EditText) findViewById(R.id.inputBunho);
        volleyer(queue).settings().setAsDefault().done();
        Context context = getApplicationContext();
        // 인증하기 버튼 누르면 로그인 화면으로 전환
        // **인증번호 확인 절차도 필요함**
        certiButton = (Button) findViewById(R.id.btncertificate);
        certiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserOtpDto userOtpDto = new UserOtpDto(inputBunho.getText().toString(), inputcertnum.getText().toString());
                try {
                    volleyer().post(Properties.serverUrl+"/auth/login")
                            .addHeader("Content-Type", "application/json")
                            .withBody(objectMapper.writeValueAsString(userOtpDto))
                            .withTargetClass(TokenResponse.class)
                            .withListener(new Response.Listener<TokenResponse>() {
                                @Override
                                public void onResponse(TokenResponse response) {
                                    if(response.getData() == null){
                                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                        return;
                                    }
                                    token = response.getData().getAccessToken();
                                    SignActivity.phone = inputBunho.getText().toString();
                                    startActivity(new Intent(getApplicationContext(), BarActivity.class));
                                }
                            })
                            .withErrorListener(new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    System.out.println(error);
                                }
                            })
                            .execute();
                    queue.start();
                    } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        });

        btnBunho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = inputBunho.getText().toString();
                System.out.println(phone);
                volleyer().post(Properties.serverUrl + "/auth/otp").addHeader("Content-Type", "text/plain").withBody(phone).withTargetClass(String.class).withListener(new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }).withErrorListener(new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                    }
                }).execute();
                queue.start();
            }
        });
        inputBunho = (EditText) findViewById(R.id.inputBunho);
        inputBunho.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String email = inputBunho.getText().toString().trim();
                if (email.matches(phoneValidation) && s.length() > 0) {
                    btnBunho.setEnabled(true);
                    SignActivity.phone = String.valueOf(inputBunho.getText());
                    System.out.println(SignActivity.phone);
                } else {
                    btnBunho.setEnabled(false);
                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        queue.stop();
        super.onDestroy();
    }
}