package com.example.firebaseretrivingdata;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    View view;
    public Holder(@NonNull View itemView) {
        super(itemView);

        view = itemView;
    }

    public void setView(Context context){

    }
}
