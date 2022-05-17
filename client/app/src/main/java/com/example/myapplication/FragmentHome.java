package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment
{
    ImageButton writingButton;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        this.writingButton = view.findViewById(R.id.WritingButton);
        this.writingButton.setOnClickListener(v ->
        {
            Intent intent = new Intent(getActivity(), WritingActivity.class);
            startActivity(intent);
        });
        return (view);
    }
}