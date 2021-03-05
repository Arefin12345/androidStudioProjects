package com.example.feedbackmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBackActivty extends AppCompatActivity implements View.OnClickListener {

    private Button sendbutton,clearbutton;
    private EditText nameEditText,messageEdittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_activty);

        sendbutton = (Button) findViewById(R.id.sendbtnid);
        clearbutton = (Button) findViewById(R.id.feedbackid);

        nameEditText = (EditText) findViewById(R.id.EditTextId);
        messageEdittext= (EditText) findViewById(R.id.feedbackid);

        sendbutton.setOnClickListener(this);
        clearbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        try {
            String name = nameEditText.getText().toString();
            String message = messageEdittext.getText().toString();


            if (v.getId() == R.id.sendbtnid) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"aa2376131@gmail.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback From App");
                intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name + "\n Message : " + message);

                startActivity(Intent.createChooser(intent, "Feedback With :"));
            } else if (v.getId() == R.id.clearbtnid) {
                nameEditText.setText("");
                messageEdittext.setText("");

            }
        }catch(Exception e){
                Toast.makeText(getApplicationContext(),"Exception : "+e,Toast.LENGTH_SHORT).show();
                
            }




    }




}
