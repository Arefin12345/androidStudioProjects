package com.example.image3;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class viewholder extends RecyclerView.ViewHolder {

    View view;

    public viewholder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }

    public void setdetails(Context context,String title,String image){
        TextView textView = view.findViewById(R.id.titleid);
        ImageView imageView = view.findViewById(R.id.imageviewid);

        textView.setText(title);
        Picasso.get().load(image).into(imageView);

        Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        itemView.startAnimation(animation);
    }
}
