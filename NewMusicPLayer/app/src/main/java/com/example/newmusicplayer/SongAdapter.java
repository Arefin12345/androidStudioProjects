package com.example.newmusicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    ArrayList<SongInfo> _songs;
    Context context;
    OnItemClickListener onItemClickListener;

    SongAdapter(Context context,ArrayList<SongInfo> _songs){
        this.context = context;
        this._songs = _songs;
    }
    public interface OnItemClickListener{
        void onItemClick(Button b,View v,SongInfo obj,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myview = LayoutInflater.from(context).inflate(R.layout.row_song,parent,false);
        return new SongHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull final SongHolder holder, final int position) {

        //etting ListValue By position
        final SongInfo c = _songs.get(position);
        holder.songname.setText(c.songName);
        holder.artistname.setText(c.artistName);
        holder.buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClick(holder.buttonAction,v,c,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return _songs.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        TextView songname,artistname;
        Button  buttonAction;


        public SongHolder(@NonNull View itemView) {
            super(itemView);
            songname = (TextView) itemView.findViewById(R.id.textViewSongName);
            artistname = (TextView) itemView.findViewById(R.id.textViewArtistName);
            buttonAction = (Button) itemView.findViewById(R.id.buttonAction);

        }

    }
}
