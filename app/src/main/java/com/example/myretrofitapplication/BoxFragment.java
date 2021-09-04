package com.example.myretrofitapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myretrofitapplication.APIutilities.ApiController;
import com.example.myretrofitapplication.Adapters.NewsAdapter;
import com.example.myretrofitapplication.Model.BoxNewsModel;
import com.example.myretrofitapplication.Model.NewsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BoxFragment extends Fragment {

    private RecyclerView recyclerView;
    private String category;
    private String api="73f9c237aded4e279c84270b5cf1497b";
    private ArrayList<NewsModel> modelArrayList;
    private NewsAdapter newsAdapter;
    private String country="us";


    public BoxFragment() {
        // Required empty public constructor
    }

    public BoxFragment(String category) {
        // Required empty public constructor
        this.category=category;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_box, container, false);

        modelArrayList=new ArrayList<>();
        newsAdapter=new NewsAdapter(getContext(),modelArrayList);
        recyclerView = v.findViewById(R.id.category_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(newsAdapter);
        if(category=="home"){
            AddNewsIntoAdapter();
        }else {
            AddNewsIntoCategoryAdapter();
        }



        return v;
    }

    private void AddNewsIntoCategoryAdapter() {
        ApiController.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<BoxNewsModel>() {
            @Override
            public void onResponse(Call<BoxNewsModel> call, Response<BoxNewsModel> response) {
                if(response.isSuccessful()){
                    modelArrayList.addAll(response.body().getArticles());
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<BoxNewsModel> call, Throwable t) {

            }
        });
    }

    private void AddNewsIntoAdapter() {
        ApiController.getApiInterface().getNews(country,100,api).enqueue(new Callback<BoxNewsModel>() {
            @Override
            public void onResponse(Call<BoxNewsModel> call, Response<BoxNewsModel> response) {
                if(response.isSuccessful()){
                    modelArrayList.addAll(response.body().getArticles());
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<BoxNewsModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();



    }
}