package com.example.myapplication.Chat;

import android.view.View;

public interface OnChatItemClickListener {
    public void onItemClick(ChatListAdapter.ViewHolder holder, View view, int position);
}
