package com.example.myapplication;

import static com.navercorp.volleyextensions.volleyer.Volleyer.volleyer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.myapplication.Book.Entity.UserInfo;
import com.example.myapplication.utils.Properties;
import com.example.myapplication.utils.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navercorp.volleyextensions.volleyer.factory.DefaultRequestQueueFactory;

public class Fragment_My extends Fragment {

    ImageView purchase_history;
    ImageView SalesHistoryButton;
    ImageView InterestsListImage;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_my, container, false);

        purchase_history = v.findViewById(R.id.PurchaseHistoryImage);
        SalesHistoryButton = v.findViewById(R.id.SalesHistoryButton);
        InterestsListImage = v.findViewById(R.id.InterestsListImage);
        TextView textView = (TextView) v.findViewById(R.id.BuyListBookName);
        TextView textView1 = (TextView) v.findViewById(R.id.BuyListPublisher);
        ObjectMapper objectMapper = new ObjectMapper();
        RequestQueue queue;
        queue = DefaultRequestQueueFactory.create(v.getContext());
        volleyer(queue).settings().setAsDefault().done();
        queue.start();

        volleyer().get(Properties.serverUrl + "/auth/me")
                .addHeader("x-access-token", Properties.token).withTargetClass(ResponseDto.class)
                .withListener(new Response.Listener<ResponseDto>() {
                    @Override
                    public void onResponse(ResponseDto response) {
                        UserInfo userInfo = (UserInfo) response.getData();
                        textView.setText(userInfo.getNickname());
                        textView1.setText(userInfo.getCollege());
                    }
                }).withErrorListener(
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );
        purchase_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BuylistActivity.class);
                startActivity(intent);
            }
        });

        SalesHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SelllistActivity.class);
                startActivity(intent);
            }
        });

        InterestsListImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LikeListActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
