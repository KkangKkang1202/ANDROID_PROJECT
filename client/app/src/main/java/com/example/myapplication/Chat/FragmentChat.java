package com.example.myapplication.Chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Chat.Dto.ChatListDto;
import com.example.myapplication.R;

public class FragmentChat extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ChatListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.chatlist, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChatListAdapter();

        // 마지막 멘트, 상대방 이름
        adapter.addItem(new ChatListDto("전화주세요", "이름1"));
        adapter.addItem(new ChatListDto("팔렸나요?", "이름2"));
        adapter.addItem(new ChatListDto("중문에서 만나요", "이름3"));
        adapter.addItem(new ChatListDto("얼마에요?", "이름4"));
        adapter.addItem(new ChatListDto("안녕하세요", "이름5"));
        adapter.addItem(new ChatListDto("책 상태가 어떻게 될까요", "이름6"));
        adapter.addItem(new ChatListDto("사진좀 보내주세요", "이름7"));

        adapter.setOnChatItemClickListener(new OnChatItemClickListener()
        {
            @Override
            public void onItemClick(ChatListAdapter.ViewHolder holder, View view, int position)
            {
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                // 자기이름을 넘김
                intent.putExtra("username", "user1");
                intent.putExtra("roomNumber", "1");
                startActivity(intent);
            }
        });
        // 리사이클러뷰에 어댑터를 연결한다.
        recyclerView.setAdapter(adapter);

        return view;
    }
}