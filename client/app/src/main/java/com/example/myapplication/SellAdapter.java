package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Book.OnPersonItemClickListener;

import java.util.ArrayList;

public class SellAdapter extends RecyclerView.Adapter<SellAdapter.ViewHolder>
{
    ArrayList<SellDto> items = new ArrayList<SellDto>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.sell_cycle_list, viewGroup, false);
        return new ViewHolder(itemView, (OnPersonItemClickListener) this);
    }

    @Override
    public void onBindViewHolder(@NonNull SellAdapter.ViewHolder holder, int position) {
        SellDto item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(SellDto item) {
        items.add(item);
    }

    public void setItems(ArrayList<SellDto> items) {
        this.items = items;
    }

    public SellDto getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, SellDto item) {
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView book_name;
        TextView book_made;
        TextView book_money;
        TextView book_time;


        public ViewHolder(@NonNull View itemView, final OnPersonItemClickListener listener) {
            super(itemView);

            book_name = itemView.findViewById(R.id.book_name);
            book_made = itemView.findViewById(R.id.book_made);
            book_money = itemView.findViewById(R.id.book_money);
            book_time = itemView.findViewById(R.id.book_time);

        }

        public void setItem(SellDto item) {
            book_name.setText(item.getName());
            book_made.setText(item.getBook());
            book_money.setText(item.getMoney());
            book_time.setText(item.getDay());
        }
    }
}

