package com.example.image3;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerviewid);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("data");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter firebaseRecycleradapter =
                new FirebaseRecyclerAdapter<>(
                        Member.class,
                        R.layout.images,
                        RecyclerView.ViewHolder.class,
                        databaseReference
                )
                {
                    @Override
                    protected void populateViewHolder(RecyclerView.ViewHolder viewHolder, Member member, int i) {
                        viewHolder.setdetails(getApplicationContext(),member.getTitle(),member.getImage());
                    }
                };

        recyclerView.setAdapter(firebaseRecycleradapter);

    }

}
