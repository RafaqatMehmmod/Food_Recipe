package com.example.recipiapi;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class CustomViewHolder extends RecyclerView.ViewHolder {



    TextView text_title, text_source;
    ImageView img_headline;
    CardView cardView;

    //ImageView like_btn;
    TextView like_text,text_time;



    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        text_title = itemView.findViewById(R.id.text_title);
        text_source = itemView.findViewById(R.id.text_serving);
        img_headline = itemView.findViewById(R.id.img_headline);
        cardView = itemView.findViewById(R.id.main_container);

        text_time =itemView.findViewById(R.id.text_time);
        like_text = (TextView) itemView.findViewById(R.id.text_like);


    }

}
