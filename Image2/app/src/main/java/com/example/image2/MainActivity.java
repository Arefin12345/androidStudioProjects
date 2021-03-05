package com.example.image2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button submitbutton;
    private EditText editText;
    private TextView textView;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();

        firebaseDatabase = FirebaseDatabase.getInstance();

        //Takes access of root node
        databaseReference = databaseReference.getRef();

        //After clicking the submit button
        this.submitbutton.setOnClickListener(this::runCode);
    }

    private void runCode(View view) {
        String data = editText.getText().toString();


        databaseReference.setValue(data);

        Toast.makeText(this,"Data Inserted Successfully....",Toast.LENGTH_SHORT).show();
    }


    private void initviews() {
    }
}
