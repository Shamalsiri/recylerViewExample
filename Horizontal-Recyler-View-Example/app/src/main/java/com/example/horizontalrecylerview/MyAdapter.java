package com.example.horizontalrecylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Article> article;

    public MyAdapter(Context context, List<Article> article) {
        this.context = context;
        this.article = article;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.article_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleTV.setText(article.get(position).getTitle());
        holder.bodyTv.setText(article.get(position).getBody());
        holder.idTv.setText(article.get(position).getId());
        holder.userIdTv.setText(article.get(position).getUserId());

    }

    @Override
    public int getItemCount() {
        return article.size();
    }
}
