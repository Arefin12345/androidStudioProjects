package com.example.firebasestoringdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button savedataButton,loadataButton;
    private EditText editText,editText2;

    //Creating database Referance
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        savedataButton = (Button) findViewById(R.id.buttonid);
        loadataButton = (Button) findViewById(R.id.loadbtnid);

        editText = (EditText) findViewById(R.id.edittextid);
        editText2 = (EditText) findViewById(R.id.edittextidtwo);

        loadataButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);

            }
        });

        savedataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata();
            }

            private void savedata() {
                String name = editText.getText().toString();
                String age = editText2.getText().toString();

                String key = databaseReference.push().getKey();

                //Storing data in student class
                Student student = new Student(name,age);

                databaseReference.child(key).setValue(student);
                Toast.makeText(getApplicationContext(),"Student Info Is Added",Toast.LENGTH_SHORT).show();

                editText.setText("");
                editText2.setText("");

            }
        });
    }
}
