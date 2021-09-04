package com.example.myretrofitapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myretrofitapplication.Model.NewsModel;
import com.example.myretrofitapplication.R;
import com.example.myretrofitapplication.ViewHolder.NewsViewHolder;
import com.example.myretrofitapplication.WebViewActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private Context context;
    private ArrayList<NewsModel> modelArrayList;

    public NewsAdapter(Context context, ArrayList<NewsModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,WebViewActivity.class);
                intent.putExtra("url",modelArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        Glide.with(context).load(modelArrayList.get(position).getUrlToImage()).into(holder.newsImage);
        holder.newsHeading.setText(modelArrayList.get(position).getTitle());
        holder.newsAuthor.setText(modelArrayList.get(position).getAuthor());
        holder.newsContent.setText(modelArrayList.get(position).getDescription());
        holder.newsPublishedAt.setText("Published At:-"+modelArrayList.get(position).getPublishedAt());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}
