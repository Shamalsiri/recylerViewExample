package com.example.horizontalrecylerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView titleTV, bodyTv, idTv, userIdTv;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        titleTV = itemView.findViewById(R.id.tv_title);
        bodyTv = itemView.findViewById(R.id.tv_body);
        idTv = itemView.findViewById(R.id.tv_id);
        userIdTv = itemView.findViewById(R.id.tv_user_id);
    }
}
