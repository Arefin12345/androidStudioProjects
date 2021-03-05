package com.example.satabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.satabasedemo.data.MyDbHelper;
import com.example.satabasedemo.model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHelper db = new MyDbHelper(MainActivity.this);

        Contact arefin = new Contact();
        arefin.setPhoneNumber("909090099");
        arefin.setName("Arefin");
        db.addContact(arefin);

        Contact tasin = new Contact();
        tasin.setPhoneNumber("909045490");
        tasin.setName("Tasin");

        db.addContact(tasin);
        Log.d("dbarefin","Id For Arefin And Tasin Are "+arefin.getId()+tasin.getId());
    }

}