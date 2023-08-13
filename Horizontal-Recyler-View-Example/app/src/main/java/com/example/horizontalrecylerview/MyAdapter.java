package com.example.horizontalrecylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<Article> article;

    public MyAdapter(Context context, List<Article> article) {
        this.context = context;
        this.article = article;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /**
         This function runs everytime this recyclerview is created.
            3 Steps to follow here.
                1. Create the View using LayoutInflator and inflate the single row view you custom created.
                2. Pass that view and give it to your custom ViewHolder you made (which mimic's the single row xml)
                3. return that ViewHolder object
         */

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.article_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        /**
            This function binds the data with the UI
         */

        holder.titleTV.setText(article.get(position).getTitle());
        holder.bodyTv.setText(article.get(position).getBody());

        /*
         * The problem was, you were trying to set the Int value directly as setText which is expecting a String value.
         * one option is what i did or other option is String.valueOf(object);
         */

        holder.idTv.setText(" " + article.get(position).getId());
        holder.userIdTv.setText(" " + article.get(position).getUserId());

    }

    @Override
    public int getItemCount() {
        return article.size();
    }


    /**
     * Normally i try to keep the ViewHolder as a static inner class inside the Adapter class
     * This way they all stay in same file, are easy to find and since its static its faster.
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {


        /**
         *
         *  ViewHolder is the one that has to mimic the custom one_row_view
         *  so that it can bind data to the respective UI elements.
         */

        TextView titleTV, bodyTv, idTv, userIdTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.tv_title);
            bodyTv = itemView.findViewById(R.id.tv_body);
            idTv = itemView.findViewById(R.id.tv_id);
            userIdTv = itemView.findViewById(R.id.tv_user_id);
        }
    }
}
