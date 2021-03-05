package com.example.firerealtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    int maxId = 0;
    Member member = new Member() {
        @NonNull
        @Override
        public Class<?> getDeclaringClass() {
            return null;
        }

        @NonNull
        @Override
        public String getName() {
            return null;
        }

        @Override
        public int getModifiers() {
            return 0;
        }

        @Override
        public boolean isSynthetic() {
            return false;
        }
    };
    EditText name,phone,email;
    Button btn;
    DatabaseReference myRef;
    String value1,value2,value3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextNameId);
        phone = findViewById(R.id.editTextPhoneId);
        email = findViewById(R.id.editTextEmailId);
        btn = findViewById(R.id.buttonsendid);

        myRef = firebaseDatabase.getReference().child("user");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Dtas will be autometically saved when the text of edittext will be changed
                if (dataSnapshot.exists()){
                    maxId = (int) dataSnapshot.getChildrenCount();

                }else{

                }

            }

            @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = name.getText().toString();
                value2 = phone.getText().toString();
                value3 = email.getText().toString();

                myRef.child(String.valueOf(maxId+1)).setValue(value1,value2);
            }

        });


    }

}