package com.example.recipiapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

// Classes qui relie les views et les données

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<Result> headlines;
    private OnFetchDataListener listener;
    boolean testclick;


    public CustomAdapter(Context context, List<Result> headlines, OnFetchDataListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.data, parent, false));

    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.text_title.setText(headlines.get(position).getTitle());
//        holder.text_source.setText(headlines.get(position).getId());
        Picasso.get().load(headlines.get(position).getImage()).into(holder.img_headline);

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }

}

