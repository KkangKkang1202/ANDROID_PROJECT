package com.example.myapplication.Book;


import com.example.myapplication.Book.Dto.Book;
import com.example.myapplication.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> implements OnPersonItemClickListener
{

    ArrayList<Book> items = new ArrayList<Book>();
    OnPersonItemClickListener listener;

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.book_list, parent, false);

        return new ViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        Book item = items.get(position);
        //holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setOnItemClicklistener(OnPersonItemClickListener listener)
    {
        this.listener = listener;
    }
    @Override
    public void onItemClick(ViewHolder holder, View view, int position)
    {
        if(listener != null)
        { listener.onItemClick(holder,view,position); }
    }
    public void addItem(Book item) {
        items.add(item);
    }

    public void setItems(ArrayList<Book> items) {
        this.items = items;
    }

    public Book getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Book item) {
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView book_name;
        TextView book_made;
        TextView book_money;
        TextView book_time;


        public ViewHolder(@NonNull View itemView, final OnPersonItemClickListener listener) {
            super(itemView);

            book_name=itemView.findViewById(R.id.book_name);
            book_made=itemView.findViewById(R.id.book_made);
            book_money=itemView.findViewById(R.id.book_money);
            book_time=itemView.findViewById(R.id.book_time);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int position = getAdapterPosition();
                    if(listener != null)
                    {
                        listener.onItemClick(ViewHolder.this, v, position); } } });

        }


        public void setItem(Book item) {
            book_name.setText(item.getUsedBookCreateDto().getBook().getName());
            book_made.setText(item.getPublisherCreateDto().getName());
            book_money.setText(item.getUsedBookCreateDto().getBook().getCost().toString());
            book_time.setText(item.getUsedBookCreateDto().getBook().getPublishedDate().toString());
        }
    }
}

