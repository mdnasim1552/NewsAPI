package com.example.myretrofitapplication.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myretrofitapplication.R;

import org.jetbrains.annotations.NotNull;

public class NewsViewHolder extends RecyclerView.ViewHolder{
    public TextView newsHeading,newsContent,newsAuthor,newsPublishedAt;
    public ImageView newsImage;
    public NewsViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        newsHeading=itemView.findViewById(R.id.news_heading);
        newsContent=itemView.findViewById(R.id.news_content);
        newsAuthor=itemView.findViewById(R.id.news_author);
        newsPublishedAt=itemView.findViewById(R.id.news_time);
        newsImage=itemView.findViewById(R.id.news_image);
    }
}
