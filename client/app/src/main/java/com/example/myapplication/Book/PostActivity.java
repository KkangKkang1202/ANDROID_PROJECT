package com.example.myapplication.Book;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Book.Entity.UsedBook;
import com.example.myapplication.Chat.ChatActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

class ViewPagerAdapter extends PagerAdapter
{
    private final Context context;
    private final ArrayList<Integer> imageList;

    public ViewPagerAdapter(Context context, ArrayList<Integer> imageList)
    {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_pager_image, container, false);

        ImageView imageView = view.findViewById(R.id.ImageViewPager);
        imageView.setImageResource(imageList.get(position));

        container.addView(view);

        return (view);
    }

    @Override
    public int getCount()
    {
        return (this.imageList.size());
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
    {
        return (view == object);
    }
}

public class PostActivity extends AppCompatActivity
{
    private static UsedBook bookCreateDto;

    public static void setData(UsedBook bookCreateDto)
    {
        PostActivity.bookCreateDto = bookCreateDto;
    }

    private ArrayList<Integer> imageList;

    ImageView heartLikeImage;
    ImageView backButtonFromDetailPage;

    TextView bookNameView;
    TextView publisherView;
    TextView userPrice;
    TextView publicationDateTextView;

    Button ChatButton;

    boolean isInterested = false;

    public void initializeData()
    {
        this.imageList = new ArrayList<>();
        this.imageList.add(R.drawable.viewpagetest);
        this.imageList.add(R.drawable.viewpagetest);
        this.imageList.add(R.drawable.viewpagetest);
    }

    public void setViewPager()
    {
        ViewPager viewPager = findViewById(R.id.ViewPager);
        viewPager.setClipToPadding(false);

        viewPager.setAdapter(new ViewPagerAdapter(this, imageList));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        this.initializeData();
        this.setViewPager();

        this.heartLikeImage = findViewById(R.id.HeartLikeImage);
        this.heartLikeImage.setOnClickListener(view ->
        {
            if(!isInterested)
            {
                this.heartLikeImage.setColorFilter(Color.parseColor("#CED8F6"), PorterDuff.Mode.SRC_IN);
                isInterested = true;
            }
            else
            {
                this.heartLikeImage.setColorFilter(null);
                isInterested = false;
            }
        });

        this.ChatButton = findViewById(R.id.ChatButton);
        this.ChatButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
            // 자기이름을 넘김
            intent.putExtra("username", "user1");
            intent.putExtra("roomNumber", "1");
            startActivity(intent);
        });

        this.backButtonFromDetailPage = findViewById(R.id.backButtonFromDetailPage);
        this.backButtonFromDetailPage.setOnClickListener(view -> finish());

        this.bookNameView = findViewById(R.id.BookNameView);
        this.publisherView = findViewById(R.id.PublisherView);
        this.userPrice = findViewById(R.id.UserPrice);
        this.publicationDateTextView = findViewById(R.id.Publication_Date_Text_View);

        this.bookNameView.setText(bookCreateDto.getBook().getName());
        this.publisherView.setText(bookCreateDto.getBook().getPublisher().getName());
        this.userPrice.setText(String.valueOf(bookCreateDto.getBook().getCost().toString()));
        this.publicationDateTextView.setText(bookCreateDto.getBook().getPublishedDate().toString());
    }
}
