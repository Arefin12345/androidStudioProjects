package com.example.datastoring;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

//    @SuppressLint("WrongViewCast")

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText  usernametextid,passwordtextid;
    private Button savebtn,loadbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.detailstextview);

        usernametextid = (EditText) findViewById(R.id.usernameedittextid);
        passwordtextid = (EditText) findViewById(R.id.passwordedittextid);

        savebtn = (Button) findViewById(R.id.btn);
        loadbtn = (Button) findViewById(R.id.btn2);

        savebtn.setOnClickListener(this);
        loadbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(textView.getId() == R.id.btn){
            String username = usernametextid.getText().toString();
            String  password = passwordtextid.getText().toString();

            if(username.equals("") && password.equals("") ) {
                Toast.makeText(getApplicationContext(),"Please Enter Your Name and Password",Toast.LENGTH_SHORT);
            }
            else{
                //Writing data
                SharedPreferences sharedPreferences = getSharedPreferences("userDeatils",MODE_PRIVATE);

                ///To edit data of Shared Preferance
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usernameKey",username);
                editor.putString("passwordKey",password);
                editor.commit();

                //Making Vacant After Entering Data
                usernametextid.setText("");
                passwordtextid.setText("");

                Toast.makeText(getApplicationContext(),"Data is Stored Successfully",Toast.LENGTH_SHORT);

            }

        }

         if(textView.getId() == R.id.btn2){
            SharedPreferences sharedPreferences = getSharedPreferences("userDeatils",MODE_PRIVATE);

            if(sharedPreferences.contains("usernameKey") && sharedPreferences.contains("passwordKey")){

                String username = sharedPreferences.getString("usernameKey","Data Not Found");
                String password = sharedPreferences.getString("passwordKey","Data Not Found");

                textView.setText(username+"\n"+password);
            }
        }
    }
}
