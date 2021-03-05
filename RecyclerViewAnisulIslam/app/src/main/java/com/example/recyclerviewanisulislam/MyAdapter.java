package com.example.recyclerviewanisulislam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    String[] title,desc;
    int[] images;

    public MyAdapter(Context context, String[] title, String[] desc, int[] images) {
        this.context = context;
        this.title = title;
        this.desc = desc;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //converting the sample layout into a view.

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =  layoutInflater.inflate(R.layout.sample_layout,parent,false);

        return new MyViewHolder(view);  //the view will be sent to the itemView of MyViewHolder and
                                        // MyViewHolder class will find all the information about images and text layout
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
    // bind the view with all gathered data from sampl_view with MyViewHolder
        holder.titleTextView.setText(title[i]);
        holder.descriptionTextView.setText(desc[i]);
        holder.flagImageView.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        //Finding the length of items
        return title.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView,descriptionTextView;
        ImageView flagImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titletextViewId);
            descriptionTextView = itemView.findViewById(R.id.descriptiontextViewId);
            flagImageView = itemView.findViewById(R.id.imageViewId);
        }
    }
}
