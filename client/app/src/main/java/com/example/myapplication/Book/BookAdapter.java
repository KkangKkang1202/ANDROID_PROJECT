package com.example.myapplication.Book;


import com.example.myapplication.Book.Entity.UsedBook;
import com.example.myapplication.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> implements OnPersonItemClickListener
{

    ArrayList<UsedBook> items = new ArrayList<UsedBook>();
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
        UsedBook item = items.get(position);
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
    public void addItem(UsedBook item) {
        items.add(item);
    }

    public void setItems(ArrayList<UsedBook> items) {
        this.items = items;
    }

    public UsedBook getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, UsedBook item) {
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


        public void setItem(UsedBook item) {
            book_name.setText(item.getBook().getName());
            book_made.setText(item.getPublisher().getName());
            book_money.setText(item.getBook().getCost().toString());
            book_time.setText(item.getBook().getPublishedDate().toString());
        }
    }
}

